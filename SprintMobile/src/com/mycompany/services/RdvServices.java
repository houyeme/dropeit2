/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import models.Rdv;
import utils.Statics;

/**
 *
 * @author jasser
 */

public class RdvServices {

    boolean resultOK;
    ConnectionRequest req;
    static RdvServices instance;
    ArrayList<Rdv> rdv = new ArrayList<>();

    private RdvServices() {
        req = new ConnectionRequest();
    }

    public static RdvServices getInstance() {

        if (instance == null) {
            instance = new RdvServices();
        }

        return instance;
    }




    //ADD poste 
    public boolean addRdvAction(Rdv p) {
        

        String url = Statics.BASE_URL + "/addrdv?nom=" + p.getNom() + "&prenom=" + p.getPrenom() + "&specialite=" + p.getSpecialite() + "&meet=" + p.getMeet();
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener((evt) -> {
            resultOK = req.getResponseCode() == 200;
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    //PARSE TASKS JSON : convert JSON to java objects
    public ArrayList<Rdv> parseJSONAction(String textJson) {

        JSONParser j = new JSONParser();

        try {

            Map<String, Object> rdvListJson = j.parseJSON(new CharArrayReader(textJson.toCharArray()));
            ArrayList<Map<String, Object>> rdvList = (ArrayList<Map<String, Object>>) rdvListJson.get("root");

            for (Map<String, Object> obj : rdvList) {

                Rdv t = new Rdv();
                float id = Float.parseFloat(obj.get("id").toString());
            //    String DateConverter  = obj.get("date").toString().substring(obj.get("date").toString().indexOf("timestamp")+ 10 , obj.get("obj").toString().lastIndexOf("}"));
           //   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            //  String dateString = formatter.format(t.getDate());
        //   String s=   obj.get("date").toString();
        //   DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      //    Date date = format.parse(s);
             //   System.out.println(s);
           //     long date = Date.parse(obj.get("date").toString());
                
     



                //System.out.println(strdate);

                t.setId((int) id);
                t.setNom(obj.get("nom").toString());
                t.setPrenom(obj.get("prenom").toString());
                t.setSpecialite(obj.get("specialite").toString());
             t.setDate(obj.get("date").toString());
             
                t.setMeet(obj.get("meet").toString());
                rdv.add(t);

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return rdv;
    }

    //GET TASKS
    public ArrayList<Rdv> getRdv() {

        String url = Statics.BASE_URL + "/allrdv/";
        ConnectionRequest request = new ConnectionRequest(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                rdv = parseJSONAction(new String(request.getResponseData()));
                request.removeResponseListener((ActionListener<NetworkEvent>) this);
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(request);
        return rdv;
    }
}
