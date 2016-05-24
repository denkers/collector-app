//=========================================
//  KYLE RUSSELL
//  AUT UNIVERSITY 2016
//  https://github.com/denkers/collector-app
//=========================================

package com.kyleruss.collector.web.card;

import com.google.gson.Gson;
import com.kyleruss.collector.ejb.entity.Cards;
import com.kyleruss.collector.ejb.entity.Decks;
import com.kyleruss.collector.ejb.entity.Users;
import com.kyleruss.collector.ejb.entityfac.ActiveUserBean;
import com.kyleruss.collector.ejb.entityfac.CardsFacade;
import com.kyleruss.collector.ejb.entityfac.DeckCardsFacade;
import com.kyleruss.collector.ejb.entityfac.DecksFacade;
import com.kyleruss.collector.web.util.ActionResponse;
import com.kyleruss.collector.web.util.ServletUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeckServlet", urlPatterns = {"/DeckServlet"})
public class DeckServlet extends HttpServlet 
{
    
    @EJB DeckCardsFacade deckCardsFacade;
    
    @EJB CardsFacade cardsFacade;
    
    @EJB DecksFacade decksFacade;
    
    @EJB ActiveUserBean activeUserBean;
    
    /**
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        
    }
    
    private void getDeckList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        Users activeUser    =   activeUserBean.getActiveUser();
        List<Decks> decks   =   decksFacade.getDecksForUser(activeUser);
        ServletUtils.jsonResponse(response, decks);
    }
    
    private void getDeck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        int deckID  =   Integer.parseInt(request.getParameter("deck_id"));
        Decks deck  =   decksFacade.find(deckID);
        ServletUtils.jsonResponse(response, deck);
    }

    /**
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        
    }
    
    private void editDeck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        
    }
    
    private void addDeck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        
    }
    
    private void removeDeck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        
    }
    
    private void addCardsToDeck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String cardListParam        =   request.getParameter("deck_cards");
        int deckID                  =   Integer.parseInt(request.getParameter("deck_id"));
        Gson gson                   =   new Gson();
        List<Integer> cardIDList    =   gson.fromJson(cardListParam, List.class);
        List<Cards> cardList        =   new ArrayList<>();
        
        for(int cardID : cardIDList)
        {
            Cards card  =   cardsFacade.find(cardID);
            cardList.add(card);
        }
        
        Decks deck      =   decksFacade.find(deckID);
        boolean result  =   deckCardsFacade.addCardsToDeck(deck, cardList);
        String message  =   "";

        if(result)
            message =   "Successfully added cards to deck";
        else
            message =   "Failed to add cards to the deck";
        
        ServletUtils.jsonResponse(response, new ActionResponse(message, result));
    }
}
