/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author jasser
 */
public class HomeForm extends Form {
    public HomeForm()
    {
        
         this.setTitle("Home");
       this.setLayout(BoxLayout.y());
       Button addrdvBtn = new Button("add Rendez vous");
       Button listrdvBtn = new Button("show Rendez vous");
       
       this.addAll(addrdvBtn,listrdvBtn);
       addrdvBtn.addActionListener((p)->new AddRdvForm().show());
       listrdvBtn.addActionListener(l->new RdvListForm().show());
    
    }
}
