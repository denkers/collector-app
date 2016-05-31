//-------------------------------------------
//  KYLE RUSSELL
//  AUT UNIVERSITY 2016
//  https://github.com/denkers/collector-app
//-------------------------------------------

package com.kyleruss.collector.mobile.base;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kyleruss.collector.mobile.Consts;
import com.kyleruss.collector.mobile.R;
import com.kyleruss.collector.mobile.comms.HTTPAsync;
import com.kyleruss.collector.mobile.comms.ServiceRequest;
import com.kyleruss.collector.mobile.user.ActiveUser;


public class CardsFragment extends Fragment
{


    public CardsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        getActivity().getActionBar().setTitle("Cards");
        fetchUserCards();
        return inflater.inflate(R.layout.fragment_cards, container, false);
    }

    private void fetchUserCards()
    {
        String username = ActiveUser.getInstance().getUser().getUsername();
        ServiceRequest request  =   new ServiceRequest(Consts.ROOT_URL + "/cards/list", true);
        request.addParam("userid", username);

        CardListServicer servicer   =   new CardListServicer();
        servicer.execute(request);
    }

    private class CardListServicer extends HTTPAsync
    {

        @Override
        protected void onPostExecute(String response)
        {
            System.out.println("RESPONSE: " + response);
        }
    }
}
