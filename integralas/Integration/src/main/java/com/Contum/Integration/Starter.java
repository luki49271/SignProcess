package com.Contum.Integration;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.Contum.Integration.models.order1s;
import com.Contum.Integration.models.order2s;
import com.Contum.Integration.models.orderLongTerm;
import com.Contum.Integration.models.prepareEnvelope;
import com.Contum.Integration.models.sendEnvelope1s1cc;
import com.Contum.Integration.models.sendEnvelope2s;
import com.Contum.Integration.models.sendEnvelopeDisposableCert1s1cc;
import com.Contum.Integration.models.sendEnvelopeDisposableCert2s;

public class Starter extends JFrame {
	
	public Starter() {
		setTitle("Form");
		setVisible(true);
		setSize(400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void Run() {
		JPanel jp = new JPanel();
		JLabel jl = new JLabel();
		
		JButton start = new JButton("Start electronic signature");
		
		jp.add(start);
		
		
		jp.add(jl);
		add(jp);
		
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComponent comp = (JComponent) e.getSource(); //close the dialog
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
				
				String sspFileId ="";
		    	
		    	
		    	
		    	FileInput file = new FileInput();
		    	ApiHandler api = new ApiHandler(file.getPath()); //muszáj paraméterben aszinkronitás miatt
		    	try {
					sspFileId = api.sendUploadTemporary();
				} catch (Exception e2) {
				}
		    	
		    	prepareEnvelope.setSspFileId(sspFileId);
		    	sendEnvelope1s1cc.setSspFileId(sspFileId);
		    	sendEnvelope2s.setSspFileId(sspFileId);
		    	sendEnvelopeDisposableCert1s1cc.setSspFileId(sspFileId);
		    	sendEnvelopeDisposableCert2s.setSspFileId(sspFileId);
		    	order1s.setSspFileId(sspFileId);
		    	order2s.setSspFileId(sspFileId);
		    	orderLongTerm.setSspFileId(sspFileId);
		    	
		    	
		    	 //******* from form *******
		        Inputs inputs = new Inputs(api);
		        inputs.starterPage();

		        //******* from file *******
//		        try {
//					DataInput fromFile = new DataInput(api);
//					fromFile.send();
//				} catch (Exception e1) {
//				}
			}
		});
	}

}
