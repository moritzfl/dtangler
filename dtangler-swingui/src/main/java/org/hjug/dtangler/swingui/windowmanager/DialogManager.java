//This product is provided under the terms of EPL (Eclipse Public License) 
//version 2.0.
//
//The full license text can be read from: https://www.eclipse.org/legal/epl-2.0/

package org.hjug.dtangler.swingui.windowmanager;

public interface DialogManager {

	public enum DialogResult {
		yes, no, cancel
	}

	DialogResult showYesNoCancelDialog(String message, String title);

}
