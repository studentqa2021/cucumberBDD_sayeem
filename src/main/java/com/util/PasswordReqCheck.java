/*
 * Copyright (c) 2022 SAM
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; version 2
 * of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package com.util;

import java.io.IOException;

/**
 *
 * @author SAM
 */
public class PasswordReqCheck 
{
    public static String passwordReqChk(String passcheck) throws IOException
    {
        final int passwordLengrh = 8;
        String specialcharacter = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
        int upperCaseCheck = 0;
        int numberCheck = 0;
        int specialch = 0;
        if(passcheck.length() < passwordLengrh)
        {
            throw new IOException ("password must be 8 character long");
        }
        for(int i = 0; i < passcheck.length(); i++)
        {
            if(Character.isUpperCase(passcheck.charAt(i)))
                upperCaseCheck++;
            else if(Character.isDigit(passcheck.charAt(i)))
                numberCheck++;
            else if(specialcharacter.contains(Character.toString(passcheck.charAt(i))))
            	specialch++;
        }
        if(upperCaseCheck > 0 && numberCheck > 0 && specialch > 0)
            return passcheck;
        else
            throw new IOException("password must "
                    + "have (1) upper and (1) Number and (1) Special Character");
    }
}
