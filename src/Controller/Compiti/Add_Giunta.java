package Controller.Compiti;

import Controller.AnagraficaController;
import Controller.MessaggioController;
import Model.GestioneModel;
import Model.Persona;
import Model.Volontario;
import View.BasicFrameView;
import View.ListaggiView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Add_Giunta {


    private BasicFrameView basicframe;
    private ListaggiView view;
    private GestioneModel model;
    private JComboBox Box;
    private String appoggio;
    private Volontario UtenteLoggato;
    private int Indice;

    private ArrayList<Persona> UTENTI;


    /*costruttore*/
    public Add_Giunta(BasicFrameView frame, Volontario Utenteloggato) {

        basicframe = frame;

        view = new ListaggiView();

        UtenteLoggato = Utenteloggato;

        Indice = 0;

        view.setLabel("Lista utenti");
        view.VisibilitaVisionaSchedaButton(true);
        view.VisibilitaAccettaButton(true);
        view.VisibilitaInviomessaggio(true);


        Box = view.getBox1();

        appoggio = "conf_giunta=0";

        model = new GestioneModel(appoggio);

        UTENTI = model.Schede("listacandidati");

        stampalista();

        basicframe.setdestra(view.getIntermedio0());

        Listener();

    }

    public void stampalista () {


        for(Persona candidato : UTENTI)
            Box.addItem(candidato.getCognome() + "    -    " +candidato.getNome());


    }

    private void Listener() {

        JButton Accetta = view.getAccettaButton();
        Accetta.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {

               AccettaAction();

           }
       });

        JButton VisionaScheda = view.getVisionaSchedaButton();
        VisionaScheda.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {

               Indice = Box.getSelectedIndex();

               AnagraficaController controller;
               controller = new AnagraficaController(basicframe, UTENTI.get(Indice), view, "listacandidati");

           }
       });

        JButton InvioMessaggio = view.getInviagliUnMessaggioButton();
        InvioMessaggio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Indice = Box.getSelectedIndex();
                System.out.print(UtenteLoggato.getNome());
                MessaggioController controller;
                controller = new MessaggioController(basicframe, UTENTI.get(Indice).getCodice_Fiscale(), UtenteLoggato.getNome()+" "+UtenteLoggato.getCognome());

            }
        });
    }

    private void AccettaAction(){

        Indice = Box.getSelectedIndex();
        String[] appoggio = new String[3];



        if(basicframe.OpotionalMessage("Accettare "+UTENTI.get(Indice).getCognome()+" "+UTENTI.get(Indice).getNome()+" ?") == 0) {

            appoggio[0] = "pass";
            appoggio[1] = "conf_giunta";
            appoggio[2] =  "1" ;

            if (UTENTI.get(Indice).UpdateSQL(appoggio)) {

                basicframe.Message("Conferma avvenuta con successo!");
                UTENTI.remove(Indice);
                Box.removeItemAt(Indice);
            }
        }
    }


}
