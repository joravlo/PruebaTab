package com.example.jorav.pruebatab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import it.gmariotti.cardslib.library.internal.CardExpand;
import it.gmariotti.cardslib.library.internal.ViewToClickToExpand;
import it.gmariotti.cardslib.library.view.CardViewNative;

public class CardsExpand extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards_expand);
        init_custom_card_expand();
    }

    private void init_custom_card_expand() {

        //Create a Card
        CustomCard card = new CustomCard(getApplicationContext());

        //This provides a simple (and useless) expand area
        CardExpand expand = new CardExpand(getApplicationContext());
        //Set inner title in Expand Area
        expand.setTitle(getString(R.string.lorem));
        card.addCardExpand(expand);


        //Set card in the cardView
        CardViewNative cardView = (CardViewNative) findViewById(R.id.carddemo_example_card_expand2);
        ViewToClickToExpand viewToClickToExpand =
                ViewToClickToExpand.builder()
                        .setupView(cardView);
        card.setViewToClickToExpand(viewToClickToExpand);
        cardView.setCard(card);
    }

}
