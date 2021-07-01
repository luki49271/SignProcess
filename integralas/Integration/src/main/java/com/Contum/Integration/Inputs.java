package com.Contum.Integration;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.Contum.Integration.models.order1s;
import com.Contum.Integration.models.order2s;
import com.Contum.Integration.models.orderLongTerm;
import com.Contum.Integration.models.sendEnvelope1s1cc;
import com.Contum.Integration.models.sendEnvelope2s;
import com.Contum.Integration.models.sendEnvelopeDisposableCert1s1cc;
import com.Contum.Integration.models.sendEnvelopeDisposableCert2s;

public class Inputs extends JFrame {

	ApiHandler api;

	JPanel jp = new JPanel();
	JLabel jl = new JLabel();

	int signer = 0;

	JButton oneSign = new JButton("Egy aláíró ");
	JButton twoSign = new JButton("Két aláíró");
	JButton longTerm = new JButton("Long Term aláírás");

	JTextField r1email = new JTextField("katonabenyo@gmail.com", 20);
	JLabel r1emaillab = new JLabel("Email address:");
	JTextField r1firstName = new JTextField("Bence", 20);
	JLabel r1firstNamelab = new JLabel("First Name:");
	JTextField r1lastName = new JTextField("Katona", 20);
	JLabel r1lastNamelab = new JLabel("Last Name:");
	JTextField r2email = new JTextField("barnabas.lukacs@contum.hu", 20);
	JLabel r2emailLab = new JLabel("Email address:");
	JTextField r2firstName = new JTextField("Barnabas", 20);
	JLabel r2firstNamelab = new JLabel("First Name:");
	JTextField r2lastName = new JTextField("Lukacs", 20);
	JLabel r2lastNamelab = new JLabel("Last Name:");
	JTextField envelopeName = new JTextField("Megrendeles", 20);
	JLabel envelopeNamelab = new JLabel("Envelope Name:");
	JTextField r1pin = new JTextField("2222", 20);
	JLabel r1pinlab = new JLabel("4 digit pin code:");
	JTextField r2pin = new JTextField("4 számjegyű pinkód", 20);
	JLabel r2pinlab = new JLabel("4digit pin code:");

	JTextField r1PhoneMobile = new JTextField("+36703881503", 20);
	JLabel r1PhoneMobilelab = new JLabel("Phone number:");
	JTextField r1DocumentIssuedOn = new JTextField("2020-07-07T00:00:00Z", 20);
	JLabel r1DocumentIssuedOnlab = new JLabel("ID card issued on:");
	JTextField r1DocumentExpiryDate = new JTextField("2021-07-29T00:00:00Z", 20);
	JLabel r1DocumentExpiryDatelab = new JLabel("ID card expiry date:");
	JTextField r1SerialNumber = new JTextField("1234", 20);
	JLabel r1serialNumberlab = new JLabel("Serial number:");
	JTextField r1DocumentNumber = new JTextField("13", 20);
	JLabel r1DocumentNumberlab = new JLabel("Document number:");
	JTextField signX = new JTextField("40", 20);
	JLabel signXLab = new JLabel("Sign field, X:");
	JTextField signY = new JTextField("131.92", 20);
	JLabel signYLab = new JLabel("Sign field, Y:");
	JTextField userId = new JTextField("GÁBOR.KOCSIS", 20);
	JLabel userIdLab = new JLabel("Uesr ID:");
	JTextField deviceId = new JTextField("RHIP20102336465137", 20);
	JLabel deviceIdLab = new JLabel("Device Id:");
	

	JTextField r2PhoneMobile = new JTextField("+36206196321", 20);
	JLabel r2PhoneMobilelab = new JLabel("Phone number:");
	JTextField r2DocumentIssuedOn = new JTextField("2020-07-07T00:00:00Z", 20);
	JLabel r2DocumentIssuedOnlab = new JLabel("ID card issued on:");
	JTextField r2DocumentExpiryDate = new JTextField("2021-07-29T00:00:00Z", 20);
	JLabel r2DocumentExpiryDatelab = new JLabel("ID card expiry date:");
	JTextField r2SerialNumber = new JTextField("5678", 20);
	JLabel r2serialNumberlab = new JLabel("Serial number:");
	JTextField r2DocumentNumber = new JTextField("23", 20);
	JLabel r2DocumentNumberlab = new JLabel("Document number:");

	JButton start = new JButton("Start electronic signature");
	JButton advanced = new JButton("Advanced electronic signature");
	JButton qualified = new JButton("Qualified electronic signature");
	JButton order = new JButton("Oriana demo");

	JButton submitButton = new JButton("Submit");

	public Inputs(ApiHandler api) {
		this.api = api;
		setTitle("Form");
		setVisible(true);
		setSize(400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void starterPage() {
		JPanel jpan = new JPanel();
		JLabel jlab = new JLabel();

		JPanel jpane = new JPanel();
		JLabel jlabe = new JLabel();

		jpan.setVisible(false);

		jpane.add(advanced);
		jpane.add(qualified);
		jpane.add(order);

		jpane.add(jlabe);
		add(jpane);

		order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jpane.setVisible(false);
				System.out.println("Alma");
				orianaForm();
			}
		});

		advanced.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jpane.setVisible(false);
				advancedForm();
			}
		});

		qualified.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jpane.setVisible(false);
				qualifiedForm();
			}
		});

	}

	private void orianaForm() {

		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(signer == 1) {
					order1s.setParameters(envelopeName.getText(), r1email.getText(), r1firstName.getText(),
							r1lastName.getText(), r1PhoneMobile.getText(),signX.getText(),signY.getText());
				}
				if(signer == 2) {
					order2s.setParameters(envelopeName.getText(), r1email.getText(), r1firstName.getText(),
							r1lastName.getText(), r1PhoneMobile.getText(), r2email.getText(), r2firstName.getText(),
							r2lastName.getText(), r2PhoneMobile.getText());
				}
				if(signer == 3) {
					orderLongTerm.setParameters(envelopeName.getText(), r1email.getText(), r1firstName.getText(),
							r1lastName.getText(), r2email.getText(), r2firstName.getText(),
							r2lastName.getText(), userId.getText(),deviceId.getText());
				}
				
				JComponent comp = (JComponent) e.getSource(); // close the dialog
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
				try { // Oriana miatt átírva a link
					if(signer == 1) {
						api.sendRequest("https://demo.esignanywhere.net/Api/v5/envelope/send", order1s.getRequest());
					}
					if(signer == 2) {
						api.sendRequest("https://demo.esignanywhere.net/Api/v5/envelope/send", order2s.getRequest());
					}
					if(signer == 3) {
						api.sendRequest("https://demo.esignanywhere.net/Api/v5/envelope/send", orderLongTerm.getRequest());
					}
					

				} catch (Exception e1) {
				}

			}

		});

		jp.add(oneSign);
		//jp.add(twoSign);
		jp.add(longTerm);
		

		add(jp);

		oneSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				signer = 1;

				JPanel jpa = new JPanel();
				JLabel jla = new JLabel();
				jp.setVisible(false);

				setTitle("Form");
				jpa.setVisible(true);
				setSize(400, 200);
				setDefaultCloseOperation(EXIT_ON_CLOSE);

				jpa.add(envelopeNamelab);
				jpa.add(envelopeName);

				jpa.add(new JLabel("---------------------------SIGNER1---------------------------"));
				jpa.add(r1emaillab);
				jpa.add(r1email);

				jpa.add(r1firstNamelab);
				jpa.add(r1firstName);

				jpa.add(r1lastNamelab);
				jpa.add(r1lastName);

				jpa.add(r1PhoneMobilelab);
				jpa.add(r1PhoneMobile);
				
				jpa.add(signXLab);
				jpa.add(signX);
				
				jpa.add(signYLab);
				jpa.add(signY);

				jpa.add(submitButton);

				jpa.add(jla);
				add(jpa);

			}
		});

		twoSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				signer = 2;

				JPanel jpa = new JPanel();
				JLabel jla = new JLabel();
				jp.setVisible(false);

				setTitle("Form");
				jpa.setVisible(true);
				setSize(400, 200);
				setDefaultCloseOperation(EXIT_ON_CLOSE);

				jpa.add(envelopeNamelab);
				jpa.add(envelopeName);

				jpa.add(new JLabel("---------------------------SIGNER1---------------------------"));
				jpa.add(r1emaillab);
				jpa.add(r1email);

				jpa.add(r1firstNamelab);
				jpa.add(r1firstName);

				jpa.add(r1lastNamelab);
				jpa.add(r1lastName);

				jpa.add(r1PhoneMobilelab);
				jpa.add(r1PhoneMobile);

				jpa.add(new JLabel("---------------------------SIGNER2---------------------------"));

				jpa.add(r2emailLab);
				jpa.add(r2email);

				jpa.add(r2firstNamelab);
				jpa.add(r2firstName);

				jpa.add(r2lastNamelab);
				jpa.add(r2lastName);

				jpa.add(r2PhoneMobilelab);
				jpa.add(r2PhoneMobile);

				jpa.add(submitButton);

				jpa.add(jla);
				add(jpa);

			}
		});
		
		longTerm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				signer = 3;

				JPanel jpa = new JPanel();
				JLabel jla = new JLabel();
				jp.setVisible(false);

				setTitle("Form");
				jpa.setVisible(true);
				setSize(400, 200);
				setDefaultCloseOperation(EXIT_ON_CLOSE);

				jpa.add(envelopeNamelab);
				jpa.add(envelopeName);

				jpa.add(new JLabel("---------------------------SIGNER1---------------------------"));
				jpa.add(r1emaillab);
				jpa.add(r1email);

				jpa.add(r1firstNamelab);
				jpa.add(r1firstName);

				jpa.add(r1lastNamelab);
				jpa.add(r1lastName);

				jpa.add(new JLabel("---------------------------SIGNER2---------------------------"));

				jpa.add(r2emailLab);
				jpa.add(r2email);

				jpa.add(r2firstNamelab);
				jpa.add(r2firstName);

				jpa.add(r2lastNamelab);
				jpa.add(r2lastName);

				jpa.add(userIdLab);
				jpa.add(userId);
				
				jpa.add(deviceIdLab);
				jpa.add(deviceId);

				jpa.add(submitButton);

				jpa.add(jla);
				add(jpa);

			}
		});

	}

	public void advancedForm() {

		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (signer == 1) {
					sendEnvelope1s1cc.setParameters(envelopeName.getText(), r1email.getText(), r1firstName.getText(),
							r1lastName.getText(), r2email.getText(), r2firstName.getText(), r2lastName.getText(),
							r1pin.getText());
				}
				if (signer == 2) {
					sendEnvelope2s.setParameters(envelopeName.getText(), r1email.getText(), r1firstName.getText(),
							r1lastName.getText(), r2email.getText(), r2firstName.getText(), r2lastName.getText(),
							r1pin.getText(), r2pin.getText());

				}

				JComponent comp = (JComponent) e.getSource(); // close the dialog
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();

				try {
					if (signer == 1) {
						api.sendRequest("https://demo.xyzmo.com/api/v4.0/envelope/send",
								sendEnvelope1s1cc.getRequest());
					}
					if (signer == 2) {
						api.sendRequest("https://demo.xyzmo.com/api/v4.0/envelope/send", sendEnvelope2s.getRequest());
					}

				} catch (Exception e1) {
				}

			}

		});

		jp.add(oneSign);
		jp.add(twoSign);

		add(jp);

		oneSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel jpa = new JPanel();
				JLabel jla = new JLabel();
				jp.setVisible(false);

				setTitle("Form");
				jpa.setVisible(true);
				setSize(400, 200);
				setDefaultCloseOperation(EXIT_ON_CLOSE);

				signer = 1;

				jpa.add(envelopeNamelab);
				jpa.add(envelopeName);

				jpa.add(new JLabel("---------------------------SIGNER---------------------------"));
				jpa.add(r1emaillab);
				jpa.add(r1email);

				jpa.add(r1firstNamelab);
				jpa.add(r1firstName);

				jpa.add(r1lastNamelab);
				jpa.add(r1lastName);

				jpa.add(r1pinlab);
				jpa.add(r1pin);

				jpa.add(new JLabel("---------------------------CC---------------------------"));

				jpa.add(r2emailLab);
				jpa.add(r2email);

				jpa.add(r2firstNamelab);
				jpa.add(r2firstName);

				jpa.add(r2lastNamelab);
				jpa.add(r2lastName);

				jpa.add(submitButton);

				jpa.add(jla);
				add(jpa);
				System.out.println(signer);
			}
		});

		twoSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel jpa = new JPanel();
				JLabel jla = new JLabel();
				jp.setVisible(false);

				setTitle("Form");
				jpa.setVisible(true);
				setSize(400, 200);
				setDefaultCloseOperation(EXIT_ON_CLOSE);

				signer = 2;

				jpa.add(envelopeNamelab);
				jpa.add(envelopeName);

				jpa.add(new JLabel("---------------------------1st. SIGNER---------------------------"));

				jpa.add(r1emaillab);
				jpa.add(r1email);

				jpa.add(r1firstNamelab);
				jpa.add(r1firstName);

				jpa.add(r1lastNamelab);
				jpa.add(r1lastName);

				jpa.add(r1pinlab);
				jpa.add(r1pin);

				jpa.add(new JLabel("---------------------------2nd. SIGNER---------------------------"));

				jpa.add(r2emailLab);
				jpa.add(r2email);

				jpa.add(r2firstNamelab);
				jpa.add(r2firstName);

				jpa.add(r2lastNamelab);
				jpa.add(r2lastName);

				jpa.add(r2pinlab);
				jpa.add(r2pin);

				jpa.add(submitButton);

				jpa.add(jla);
				add(jpa);
				System.out.println(signer);
			}
		});

	}

	public void qualifiedForm() {
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (signer == 1) {
					sendEnvelopeDisposableCert1s1cc.setParameters(envelopeName.getText(), r1email.getText(),
							r1firstName.getText(), r1lastName.getText(), r1PhoneMobile.getText(),
							r1DocumentIssuedOn.getText(), r1DocumentExpiryDate.getText(), r1SerialNumber.getText(),
							r1DocumentNumber.getText(), r2email.getText(), r2firstName.getText(), r2lastName.getText());
				}
				if (signer == 2) {
					sendEnvelopeDisposableCert2s.setParameters(envelopeName.getText(), r1email.getText(),
							r1firstName.getText(), r1lastName.getText(), r1PhoneMobile.getText(),
							r1DocumentIssuedOn.getText(), r1DocumentExpiryDate.getText(), r1SerialNumber.getText(),
							r1DocumentNumber.getText(), r2email.getText(), r2firstName.getText(), r2lastName.getText(),
							r2PhoneMobile.getText(), r2DocumentIssuedOn.getText(), r2DocumentExpiryDate.getText(),
							r2SerialNumber.getText(), r2DocumentNumber.getText());

				}

				JComponent comp = (JComponent) e.getSource(); // close the dialog
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();

				try {
					if (signer == 1) {
						api.sendRequest("https://demo.xyzmo.com/api/v4.0/envelope/send",
								sendEnvelopeDisposableCert1s1cc.getRequest());
					}
					if (signer == 2) {
						System.out.println(sendEnvelopeDisposableCert2s.getRequest());
						api.sendRequest("https://demo.xyzmo.com/api/v4.0/envelope/send",
								sendEnvelopeDisposableCert2s.getRequest());
					}

				} catch (Exception e1) {
				}

			}

		});

		jp.add(oneSign);
		jp.add(twoSign);

		add(jp);

		oneSign.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JPanel jpa = new JPanel();
				JLabel jla = new JLabel();
				jp.setVisible(false);

				setTitle("Form");
				jpa.setVisible(true);
				setSize(400, 200);
				setDefaultCloseOperation(EXIT_ON_CLOSE);

				signer = 1;

				jpa.add(envelopeNamelab);
				jpa.add(envelopeName);

				jpa.add(new JLabel("---------------------------SIGNER---------------------------"));

				jpa.add(r1emaillab);
				jpa.add(r1email);

				jpa.add(r1firstNamelab);
				jpa.add(r1firstName);

				jpa.add(r1lastNamelab);
				jpa.add(r1lastName);

				jpa.add(r1PhoneMobilelab);
				jpa.add(r1PhoneMobile);
				jpa.add(r1DocumentIssuedOnlab);
				jpa.add(r1DocumentIssuedOn);
				jpa.add(r1DocumentExpiryDatelab);
				jpa.add(r1DocumentExpiryDate);
				jpa.add(r1serialNumberlab);
				jpa.add(r1SerialNumber);
				jpa.add(r1DocumentNumberlab);
				jpa.add(r1DocumentNumber);

				jpa.add(new JLabel("---------------------------CC---------------------------"));

				jpa.add(r2emailLab);
				jpa.add(r2email);

				jpa.add(r2firstNamelab);
				jpa.add(r2firstName);

				jpa.add(r2lastNamelab);
				jpa.add(r2lastName);

				jpa.add(submitButton);

				jpa.add(jla);
				add(jpa);
				System.out.println(signer);
			}
		});

		twoSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel jpa = new JPanel();
				JLabel jla = new JLabel();
				jp.setVisible(false);

				setTitle("Form");
				jpa.setVisible(true);
				setSize(400, 200);
				setDefaultCloseOperation(EXIT_ON_CLOSE);

				signer = 2;

				jpa.add(envelopeNamelab);
				jpa.add(envelopeName);

				jpa.add(new JLabel("---------------------------1st. SIGNER---------------------------"));

				jpa.add(r1emaillab);
				jpa.add(r1email);

				jpa.add(r1firstNamelab);
				jpa.add(r1firstName);

				jpa.add(r1lastNamelab);
				jpa.add(r1lastName);

				jpa.add(r1PhoneMobilelab);
				jpa.add(r1PhoneMobile);
				jpa.add(r1DocumentIssuedOnlab);
				jpa.add(r1DocumentIssuedOn);
				jpa.add(r1DocumentExpiryDatelab);
				jpa.add(r1DocumentExpiryDate);
				jpa.add(r1serialNumberlab);
				jpa.add(r1SerialNumber);
				jpa.add(r1DocumentNumberlab);
				jpa.add(r1DocumentNumber);

				jpa.add(new JLabel("---------------------------2nd. SIGNER---------------------------"));

				jpa.add(r2emailLab);
				jpa.add(r2email);

				jpa.add(r2firstNamelab);
				jpa.add(r2firstName);

				jpa.add(r2lastNamelab);
				jpa.add(r2lastName);

				jpa.add(r2PhoneMobilelab);
				jpa.add(r2PhoneMobile);
				jpa.add(r2DocumentIssuedOnlab);
				jpa.add(r2DocumentIssuedOn);
				jpa.add(r2DocumentExpiryDatelab);
				jpa.add(r2DocumentExpiryDate);
				jpa.add(r2serialNumberlab);
				jpa.add(r2SerialNumber);
				jpa.add(r2DocumentNumberlab);
				jpa.add(r2DocumentNumber);

				jpa.add(submitButton);

				jpa.add(jla);
				add(jpa);
				System.out.println(signer);
			}
		});

	}

}
