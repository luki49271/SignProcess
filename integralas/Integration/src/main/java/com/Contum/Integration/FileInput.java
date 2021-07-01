package com.Contum.Integration;

import java.awt.FileDialog;
import java.io.File;

import javax.swing.JFrame;

public class FileInput {

	public static String getPath() {
		FileDialog fd = new FileDialog(new JFrame());
		fd.setVisible(true);
		File[] files = fd.getFiles();
		if (files.length > 0) {
			return files[0].getAbsolutePath();
		}
		return null;
	}
}
