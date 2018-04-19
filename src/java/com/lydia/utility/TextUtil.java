/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lydia.utility;

import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;

/**
 *
 * @author Lydia - 1672014
 */
public class TextUtil {

    public static boolean isEmptyField(TextField... textFields) {
        for (TextInputControl tic : textFields) {
            if (tic.getText().trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
