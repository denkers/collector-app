<?php
	include 'lib/simple_html_dom.php';

	$cardTypes	=	
	[
		'grass',
		'fire',
		'water',
		'lightning',
		'psychic',
		'fighting',
		'darkness',
		'metal',
		'colorless',
		'fairy',
		'dragon'
	];

	function getCardsForPage($page, $type, &$importScript = "")
	{
		$baseURL		=	"http://www.pokemon.com";
		$link			=	$baseURL . "/us/pokemon-tcg/pokemon-cards/$page?&cardName=&cardText=&evolvesFrom=&simpleSubmit=
							&format=unlimited&hitPointsMin=0&hitPointsMax=250&retreatCostMin=0&retreatCostMax=5&totalAttackCostMin=0
							&totalAttackCostMax=5&particularArtist=&card-$type=on";
		$dom			=	file_get_html($link);
		$recordScript	=	"";

		foreach($dom->find('ul[id=cardResults]', 0)->find('a') as $a)
		{
			$cardImg	=	$a->find('img', 0);
			$cardImgURL	=	'http://' . substr($cardImg->src, 2, strlen($cardImg->src));
			$cardName	=	$cardImg->alt;
			$filePath	=	"images/$type/" . $cardName . ".png";

			file_put_contents($filePath, @fopen($cardImgURL, 'r'));
			$recordScript	.=	getInsertRecordScript($cardName, $filePath, $type) . ",\n";
		} 

		$importScript	.=	$recordScript;
} 

	function getInsertRecordScript($name, $picturePath, $type)
	{
		global $cardTypes;
		$filteredName	=	preg_replace('/[^a-zA-Z]/', "", $name);
		$typeID			=	array_search($type, $cardTypes) + 1;
		return "('$filteredName', '$picturePath', $typeID)";
	}

	function getInitInsertScript()
	{
		return 'INSERT INTO cards (name, picture, card_type) VALUES';
	}

	function getCards()
	{
		global $cardTypes;
		$importScript	=	getInitInsertScript();

		foreach($cardTypes as $cardType)
		{
			for($page = 1; $page <= 9; $page++)
				getCardsForPage($page, $cardType, $importScript);
		}

		echo "done";

		$importScript	=	substr($importScript, 0, strlen($importScript) - 2) . ";";
		file_put_contents('importscript.sql', $importScript);
	}


	getCards();

?>
