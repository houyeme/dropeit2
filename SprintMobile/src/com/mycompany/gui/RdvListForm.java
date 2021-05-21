/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import static com.codename1.io.Log.p;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;
import java.util.ArrayList;
import models.Rdv;
import services.RdvServices;

/**
 *
 * @author jasser
 */
public class RdvListForm extends Form {
    public RdvListForm() 
    {
       // ArrayList<Rdv>p=RdvServices.getInstance().getRdv();
       
        this.setTitle("Rdv List");
        this.setLayout(BoxLayout.y());
        
        //SpanLabel sp = new SpanLabel();
        
      
      //  sp.setText(RdvServices.getInstance().getRdv().toString());
      //  this.add(sp);
              ArrayList<Rdv> liste = RdvServices.getInstance().getRdv();
 for (Rdv c : liste) {
 SpanLabel sp = new SpanLabel();
        sp.setText(c.getDate());
        add(sp);
    
          }
        
       /*   for(int i=14;i<p.size();i++)
            
        {    
          
 
                
                 
              
                Form cn=new Form("caption"+i+":"+p.get(i).getNom());
                cn.setLayout(BoxLayout.y());
               
                
                
                
                //Label ltitre=new Label();
                Label lgroupe=new Label();
                SpanLabel posteListSP = new SpanLabel();
                //ltitre.setText(p.get(i).getTitre());
                posteListSP.setText(p.get(i).getPrenom());
                lgroupe.setText(p.get(i).getSpecialite());
                cn.addAll(posteListSP);
                this.add(cn);
            }
            // SpanLabel posteListSP = new SpanLabel();
            // posteListSP.setText(p.toString());
        
        
        */
        
          getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, ev-> new HomeForm().showBack());

    }
}
