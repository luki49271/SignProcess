package com.Contum.Integration.models;

public class sendEnvelopeDisposableCert1s1cc extends sendEnvelopeBase {
	
	
	public static String r1PhoneMobile; 
	public static String r1DocumentIssuedOn; 
	public static String r1DocumentExpiryDate; 	
	public static String r1SerialNumber;
	public static String r1DocumentNumber;

	
	
	public static String getR1PhoneMobile() {
		return r1PhoneMobile;
	}
	public static void setR1PhoneMobile(String r1PhoneMobile) {
		sendEnvelopeDisposableCert1s1cc.r1PhoneMobile = r1PhoneMobile;
	}
	public static String getR1DocumentIssuedOn() {
		return r1DocumentIssuedOn;
	}
	public static void setR1DocumentIssuedOn(String r1DocumentIssuedOn) {
		sendEnvelopeDisposableCert1s1cc.r1DocumentIssuedOn = r1DocumentIssuedOn;
	}
	public static String getR1DocumentExpiryDate() {
		return r1DocumentExpiryDate;
	}
	public static void setR1DocumentExpiryDate(String r1DocumentExpiryDate) {
		sendEnvelopeDisposableCert1s1cc.r1DocumentExpiryDate = r1DocumentExpiryDate;
	}
	public static String getR1SerialNumber() {
		return r1SerialNumber;
	}
	public static void setR1SerialNumber(String r1SerialNumber) {
		sendEnvelopeDisposableCert1s1cc.r1SerialNumber = r1SerialNumber;
	}
	public static String getR1DocumentNumber() {
		return r1DocumentNumber;
	}
	public static void setR1DocumentNumber(String r1DocumentNumber) {
		sendEnvelopeDisposableCert1s1cc.r1DocumentNumber = r1DocumentNumber;
	}
	
	
	public static void setParameters(String envelopeName, String r1Email,String r1FirstName, String r1LastName,
			String r1PhoneMobile, String r1DocumentIssuedOn, String r1DocumentExpiryDate, String r1SerialNumber,
			String  r1DocumentNumber,String r2Email,  String r2FirstName, String r2LastName) {
		setEnvelopeName(envelopeName);
		setR1Email(r1Email);
		setR1FirstName(r1FirstName);
		setR1LastName(r1LastName);
		setR1PhoneMobile(r1PhoneMobile);
		setR1DocumentIssuedOn(r1DocumentIssuedOn);
		setR1DocumentExpiryDate(r1DocumentExpiryDate);
		setR1SerialNumber(r1SerialNumber);
		setR1DocumentNumber(r1DocumentNumber);
		setR2Email(r2Email);
		setR2FirstName(r2FirstName);
		setR2LastName(r2LastName);
		
	}

	
	public static String getRequest() {
		return "{\r\n"
				+ "  \"SspFileIds\": [\r\n"
				+ "    \""+sspFileId+"\"\r\n"
				+ "  ],\r\n"
				+ "  \"SendEnvelopeDescription\": {\r\n"
				+ "  \"Name\": \""+envelopeName+"\",\r\n"
				+ "  \"EmailSubject\": \"Please sign the enclosed envelope\",\r\n"
				+ "  \"EmailBody\": \"Dear #RecipientFirstName# #RecipientLastName#\\n\\n#PersonalMessage#\\n\\nPlease sign the envelope #EnvelopeName#\\n\\nEnvelope will expire at #ExpirationDate#\",\r\n"
				+ "  \"DisplayedEmailSender\": \"\",\r\n"
				+ "  \"EnableReminders\": true,\r\n"
				+ "  \"FirstReminderDayAmount\": 5,\r\n"
				+ "  \"RecurrentReminderDayAmount\": 3,\r\n"
				+ "  \"BeforeExpirationDayAmount\": 3,\r\n"
				+ "  \"DaysUntilExpire\": 28,\r\n"
				+ "  \"CallbackUrl\": \"\",\r\n"
				+ "  \"StatusUpdateCallbackUrl\": \"\",\r\n"
				+ "  \"LockFormFieldsAtEnvelopeFinish\": true,\r\n"
				+ "  \"Steps\": [\r\n"
				+ "    {\r\n"
				+ "      \"OrderIndex\": 1,\r\n"
				+ "      \"Recipients\": [\r\n"
				+ "        {\r\n"
				+ "            \"Email\": \""+r1Email+"\",\r\n"
				+ "          \"FirstName\": \""+r1FirstName+"\",\r\n"
				+ "          \"LastName\": \""+r1LastName+"\",\r\n"
				+ "          \"LanguageCode\": \"en\",\r\n"
				+ "          \"EmailBodyExtra\": \"\",\r\n"
				+ "          \"DisableEmail\": false,\r\n"
				+ "          \"AddAndroidAppLink\": false,\r\n"
				+ "          \"AddIosAppLink\": false,\r\n"
				+ "          \"AddWindowsAppLink\": false,\r\n"
				+ "          \"AllowDelegation\": false,\r\n"
				+ "          \"AllowAccessFinishedWorkstep\": false,\r\n"
				+ "          \"SkipExternalDataValidation\": false,\r\n"
				+ "          \"AuthenticationMethods\": [],\r\n"
				+ "          \"DisposableCertificateData\": {\r\n"
				+ "            \"CountryResidence\": \"HU\",\r\n"
				+ "            \"IdentificationCountry\": \"HU\",\r\n"
				+ "            \"IdentificationType\": \"PASSPORT\",\r\n"
				+ "            \"PhoneMobile\": \""+r1PhoneMobile+"\",\r\n"
				+ "            \"DocumentType\": \"PASS\",\r\n"
				+ "            \"DocumentIssuedBy\": \"Namirial\",\r\n"
				+ "            \"DocumentIssuedOn\": \""+r1DocumentIssuedOn+"\",\r\n"
				+ "            \"DocumentExpiryDate\": \""+r1DocumentExpiryDate+"\",\r\n"
				+ "            \"SerialNumber\": \""+r1SerialNumber+"\",\r\n"
				+ "            \"DocumentNumber\": \""+r1DocumentNumber+"\",\r\n"
				+ "            \"OverrideHolderInCaseOfMismatch\": false\r\n"
				+ "          }\r\n"
				+ "        }\r\n"
				+ "      ],\r\n"
				+ "      \"EmailBodyExtra\": \"\",\r\n"
				+ "      \"RecipientType\": \"Signer\",\r\n"
				+ "      \"WorkstepConfiguration\": {\r\n"
				+ "        \"WorkstepLabel\": \"test\",\r\n"
				+ "        \"SmallTextZoomFactorPercent\": 100,\r\n"
				+ "        \"FinishAction\": {\r\n"
				+ "          \"ServerActions\": [],\r\n"
				+ "          \"ClientActions\": [\r\n"
				+ "            {\r\n"
				+ "              \"RemoveDocumentFromRecentDocumentList\": false,\r\n"
				+ "              \"CallClientActionOnlyAfterSuccessfulSync\": true,\r\n"
				+ "              \"ClientName\": \"SIGNificant SignAnywhere\",\r\n"
				+ "              \"CloseApp\": false,\r\n"
				+ "              \"Action\": \"https://www.esignanywhere.net/\"\r\n"
				+ "            }\r\n"
				+ "          ]\r\n"
				+ "        },\r\n"
				+ "        \"ReceiverInformation\": {\r\n"
				+ "          \"UserInformation\": {\r\n"
				+ "            \"FirstName\": \""+r1FirstName+"\",\r\n"
				+ "            \"LastName\": \""+r1LastName+"\",\r\n"
				+ "            \"EMail\": \""+r1Email+"\"\r\n"
				+ "          },\r\n"
				+ "          \"HolderInformation\": \"<recognitionType>PASS</recognitionType><documentIssuedOn>07/07/2020</documentIssuedOn><documentExpiryDate>29/07/2021</documentExpiryDate><documentIssuedBy>Namirial</documentIssuedBy><documentNumber>123</documentNumber><countryResidence>HU</countryResidence><firstName>Bence</firstName><lastName>Katona</lastName><email>katonabenyo@gmail.com</email><phoneMobile>+36703881503</phoneMobile><identificationType>PASSPORT</identificationType><identificationCountry>HU</identificationCountry><passport>1234</passport>\",\r\n"
				+ "          \"TransactionCodePushPluginData\": []\r\n"
				+ "        },\r\n"
				+ "        \"SenderInformation\": {\r\n"
				+ "          \"UserInformation\": {\r\n"
				+ "            \"FirstName\": \""+r2FirstName+"\",\r\n"
				+ "            \"LastName\": \""+r2LastName+"\",\r\n"
				+ "            \"EMail\": \""+r2Email+"\"\r\n"
				+ "          }\r\n"
				+ "        },\r\n"
				+ "        \"TransactionCodeConfigurations\": [\r\n"
				+ "          {\r\n"
				+ "            \"Id\": \"smsAuthTransactionCodeId\",\r\n"
				+ "            \"HashAlgorithmIdentifier\": \"Sha256\",\r\n"
				+ "            \"Texts\": [\r\n"
				+ "              {\r\n"
				+ "              }\r\n"
				+ "            ]\r\n"
				+ "          }\r\n"
				+ "        ],\r\n"
				+ "        \"SignatureConfigurations\": [],\r\n"
				+ "        \"ViewerPreferences\": {\r\n"
				+ "          \"FinishWorkstepOnOpen\": false,\r\n"
				+ "          \"VisibleAreaOptions\": {\r\n"
				+ "            \"AllowedDomain\": \"*\",\r\n"
				+ "            \"Enabled\": false\r\n"
				+ "          }\r\n"
				+ "        },\r\n"
				+ "        \"ResourceUris\": {},\r\n"
				+ "        \"AuditingToolsConfiguration\": {\r\n"
				+ "          \"WriteAuditTrail\": false,\r\n"
				+ "          \"NotificationConfiguration\": {}\r\n"
				+ "        },\r\n"
				+ "        \"Policy\": {\r\n"
				+ "          \"GeneralPolicies\": {\r\n"
				+ "            \"AllowSaveDocument\": true,\r\n"
				+ "            \"AllowSaveAuditTrail\": true,\r\n"
				+ "            \"AllowRotatingPages\": false,\r\n"
				+ "            \"AllowEmailDocument\": true,\r\n"
				+ "            \"AllowPrintDocument\": true,\r\n"
				+ "            \"AllowFinishWorkstep\": true,\r\n"
				+ "            \"AllowRejectWorkstep\": true,\r\n"
				+ "            \"AllowRejectWorkstepDelegation\": false,\r\n"
				+ "            \"AllowUndoLastAction\": true,\r\n"
				+ "            \"AllowAdhocPdfAttachments\": false,\r\n"
				+ "            \"AllowAdhocSignatures\": false,\r\n"
				+ "            \"AllowAdhocStampings\": false,\r\n"
				+ "            \"AllowAdhocFreeHandAnnotations\": false,\r\n"
				+ "            \"AllowAdhocTypewriterAnnotations\": false,\r\n"
				+ "            \"AllowAdhocPictureAnnotations\": false,\r\n"
				+ "            \"AllowAdhocPdfPageAppending\": false\r\n"
				+ "          },\r\n"
				+ "          \"WorkstepTasks\": {\r\n"
				+ "            \"PictureAnnotationMinResolution\": 0,\r\n"
				+ "            \"PictureAnnotationMaxResolution\": 0,\r\n"
				+ "            \"PictureAnnotationColorDepth\": \"Color16M\",\r\n"
				+ "            \"SequenceMode\": \"NoSequenceEnforced\",\r\n"
				+ "            \"PositionUnits\": \"PdfUnits\",\r\n"
				+ "            \"ReferenceCorner\": \"Lower_Left\",\r\n"
				+ "            \"Tasks\": [\r\n"
				+ "              {\r\n"
				+ "                \"PositionPage\": 1,\r\n"
				+ "                \"Position\": {\r\n"
				+ "                \"PositionX\": 40,\r\n"
				+ "                  \"PositionY\": 742\r\n"
				+ "                },\r\n"
				+ "                \"Size\": {\r\n"
				+ "                 \"Height\": 80,\r\n"
				+ "                  \"Width\": 190\r\n"
				+ "                },\r\n"
				+ "                \"AdditionalParameters\": [\r\n"
				+ "                  {\r\n"
				+ "                    \"Key\": \"enabled\",\r\n"
				+ "                    \"Value\": \"1\"\r\n"
				+ "                  },\r\n"
				+ "                  {\r\n"
				+ "                    \"Key\": \"positioning\",\r\n"
				+ "                    \"Value\": \"onPage\"\r\n"
				+ "                  },\r\n"
				+ "                  {\r\n"
				+ "                    \"Key\": \"req\",\r\n"
				+ "                    \"Value\": \"1\"\r\n"
				+ "                  },\r\n"
				+ "                  {\r\n"
				+ "                    \"Key\": \"fd\",\r\n"
				+ "                    \"Value\": \"\"\r\n"
				+ "                  },\r\n"
				+ "                  {\r\n"
				+ "                    \"Key\": \"fd_dateformat\",\r\n"
				+ "                    \"Value\": \"dd-MM-yyyy HH:mm:ss\"\r\n"
				+ "                  },\r\n"
				+ "                  {\r\n"
				+ "                    \"Key\": \"fd_timezone\",\r\n"
				+ "                    \"Value\": \"datetimeutc+1\"\r\n"
				+ "                  },\r\n"
				+ "                  {\r\n"
				+ "                    \"Key\": \"spcId\",\r\n"
				+ "                    \"Value\": \"padesSigningId\"\r\n"
				+ "                  }\r\n"
				+ "                ],\r\n"
				+ "                \"AllowedSignatureTypes\": [\r\n"
				+ "                  {\r\n"
				+ "                    \"TrModType\": \"RemoteSignatureDisposableCertificate\",\r\n"
				+ "                    \"TrValidityInSeconds\": 300,\r\n"
				+ "                    \"Ly\": \"remoteCertificate\",\r\n"
				+ "                    \"TrConfIdIssueCertificate\": \"disposableCertificateEnrolAndSignSmsText\",\r\n"
				+ "                    \"TrConfId\": \"remoteCertificateSignSmsText\",\r\n"
				+ "                    \"IsPhoneNumberRequired\": false,\r\n"
				+ "                    \"Id\": \"180c4201-4146-4161-baf8-cb5a607eec62\",\r\n"
				+ "                    \"DiscriminatorType\": \"SigTypeTransactionCode\",\r\n"
				+ "                    \"Preferred\": false,\r\n"
				+ "                    \"StampImprintConfiguration\": {\r\n"
				+ "                      \"DisplayExtraInformation\": true,\r\n"
				+ "                      \"DisplayEmail\": true,\r\n"
				+ "                      \"DisplayIp\": true,\r\n"
				+ "                      \"DisplayName\": true,\r\n"
				+ "                      \"DisplaySignatureDate\": true,\r\n"
				+ "                      \"FontFamily\": \"Times New Roman\",\r\n"
				+ "                      \"FontSize\": 11.0\r\n"
				+ "                    }\r\n"
				+ "                  }\r\n"
				+ "                ],\r\n"
				+ "                \"UseTimestamp\": false,\r\n"
				+ "                \"IsRequired\": true,\r\n"
				+ "                \"Id\": \"1#XyzmoDuplicateIdSeperator#Signature_b58c192b-47c0-5339-cb18-4fe77c3d1812\",\r\n"
				+ "                \"DisplayName\": \"\",\r\n"
				+ "                \"DocRefNumber\": 1,\r\n"
				+ "                \"DiscriminatorType\": \"Signature\"\r\n"
				+ "              }\r\n"
				+ "            ]\r\n"
				+ "          }\r\n"
				+ "        },\r\n"
				+ "        \"Navigation\": {\r\n"
				+ "          \"HyperLinks\": [],\r\n"
				+ "          \"Links\": [],\r\n"
				+ "          \"LinkTargets\": []\r\n"
				+ "        }\r\n"
				+ "      },\r\n"
				+ "      \"DocumentOptions\": [\r\n"
				+ "        {\r\n"
				+ "          \"DocumentReference\": \"1\",\r\n"
				+ "          \"IsHidden\": false\r\n"
				+ "        }\r\n"
				+ "      ],\r\n"
				+ "      \"UseDefaultAgreements\": true\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"OrderIndex\": 2,\r\n"
				+ "      \"Recipients\": [\r\n"
				+ "        {\r\n"
				+ "          \"Email\": \""+r2Email+"\",\r\n"
				+ "          \"FirstName\": \""+r2FirstName+"\",\r\n"
				+ "          \"LastName\": \""+r2LastName+"\",\r\n"
				+ "          \"LanguageCode\": \"en\",\r\n"
				+ "          \"EmailBodyExtra\": \"\",\r\n"
				+ "          \"DisableEmail\": false,\r\n"
				+ "          \"AddAndroidAppLink\": false,\r\n"
				+ "          \"AddIosAppLink\": false,\r\n"
				+ "          \"AddWindowsAppLink\": false,\r\n"
				+ "          \"AllowDelegation\": false,\r\n"
				+ "          \"SkipExternalDataValidation\": false,\r\n"
				+ "          \"AuthenticationMethods\": []\r\n"
				+ "        }\r\n"
				+ "      ],\r\n"
				+ "      \"EmailBodyExtra\": \"\",\r\n"
				+ "      \"RecipientType\": \"Cc\",\r\n"
				+ "      \"DocumentOptions\": [],\r\n"
				+ "      \"UseDefaultAgreements\": false\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"AddFormFields\": {\r\n"
				+ "    \"Forms\": {}\r\n"
				+ "  },\r\n"
				+ "  \"OverrideFormFieldValues\": {\r\n"
				+ "    \"Forms\": {}\r\n"
				+ "  },\r\n"
				+ "  \"AttachSignedDocumentsToEnvelopeLog\": false\r\n"
				+ "}\r\n"
				+ "}";
	}
	
	

}
