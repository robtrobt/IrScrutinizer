/*
Copyright (C) 2013 Bengt Martensson.

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

package org.harctoolbox.irscrutinizer.importer;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.harctoolbox.IrpMaster.ModulatedIrSequence;
import org.harctoolbox.IrpMaster.Wave;

/**
 * This class wraps the IrpMaster Wave class to an importer.
 */
public class WaveImporter extends FileImporter implements IModulatedIrSequenceImporter,IFileImporter {

    private boolean divideCarrier;
    private ModulatedIrSequence sequence;

    public WaveImporter(boolean divideCarrier) {
        super();
        this.divideCarrier = divideCarrier;
    }

    /**
     * @param divideCarrier the divideCarrier to set
     */
    public void setDivideCarrier(boolean divideCarrier) {
        this.divideCarrier = divideCarrier;
    }

    @Override
    public void load(File file, String origin) throws IOException {
        try {
            Wave wave = new Wave(file);
            sequence = wave.analyze(divideCarrier);
        } catch (UnsupportedAudioFileException ex) {
            throw new IOException(ex.getMessage());
        }
    }

    @Override
    public String[][] getFileExtensions() {
        return new String[][]{new String[]{"Wave files (*.wav *.wave)", "wave", "wav" }};
    }

    @Override
    public String getFormatName() {
        return "Wave";
    }

    @Override
    public ModulatedIrSequence getModulatedIrSequence() {
        return sequence;
    }
}
