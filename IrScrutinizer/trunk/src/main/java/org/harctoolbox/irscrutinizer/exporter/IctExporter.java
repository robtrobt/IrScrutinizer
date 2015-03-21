/*
Copyright (C) 2013, 2014 Bengt Martensson.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 3 of the License, or (at
your option) any later version.

This program is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
General Public License for more details.

You should have received a copy of the GNU General Public License along with
this program. If not, see http://www.gnu.org/licenses/.
*/

package org.harctoolbox.irscrutinizer.exporter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import org.harctoolbox.IrpMaster.ICT;
import org.harctoolbox.IrpMaster.IrpMasterException;
import org.harctoolbox.IrpMaster.IrpUtils;
import org.harctoolbox.IrpMaster.ModulatedIrSequence;
import org.harctoolbox.girr.Command;

/**
 * This class performs export in the IrScope ICT format.
 */
public class IctExporter extends CommandExporter implements ICommandExporter {

    public IctExporter() {
        super();
    }

    @Override
    public String[][] getFileExtensions() {
        return new String[][]{ new String[] { "IrScope files (*.ict)", "ict" } };
    }

    @Override
    public String getFormatName() {
        return "ICT";
    }

    @Override
    public String getPreferredFileExtension() {
        return "ict";
    }

    @Override
    public void export(Command command, String source, String title, int count, File exportFile) throws IrpMasterException, FileNotFoundException {
        ModulatedIrSequence seq = command.toModulatedIrSequence(1);
        PrintStream printStream = null;
        try {
            try {
                printStream = new PrintStream(exportFile, IrpUtils.dumbCharsetName);
            } catch (UnsupportedEncodingException ex) {
                // cannot happen
                return;
            }
            printStream.println(ICT.ictString(seq));
        } finally {
            if (printStream != null)
                printStream.close();
        }
    }
}
