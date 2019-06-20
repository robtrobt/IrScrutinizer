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

package org.harctoolbox.guicomponents;

import java.io.IOException;
import org.harctoolbox.ircore.InvalidArgumentException;
import org.harctoolbox.ircore.Pronto;

/**
 *
 */
public class TimeFrequencyCalculator extends HarcPanel {
    private static final String helpText =
            "This pane computes, for a carrier frequency given either in Hz or as a Pronto code\n"
            + "(i.e., the second number in the CCF), either the time for a given number of periods\n"
            + "(entered as decimal or hexadecimal), or the number of periods as a function of the time entered.\n\n"
            + "Mathematically, time = no_periods/frequency."
            ;

    public static final String versionString = "0.3.0";
    public static final String aboutText =
            "HexCalculator version " + versionString + ".\n"
            + "Copyright 2012, 2013 by Bengt Martensson.\n\n"
            + "License: GPL3.\n\n"
            + "Project home page: http://www.harctoolbox.org";

    private final static int seconds2microseconds = 1000000;

    /**
     * Creates new form TimeFrequencyCalculator
     */
    public TimeFrequencyCalculator() {
        initComponents();
    }

    private void updateFromFrequency() {
        try {
            double freq = Double.parseDouble(frequencyTextField.getText());
            prontocodeTextField.setText(Pronto.formatInteger(Pronto.frequencyCode(freq)));
            updateFromFrequency(freq);
        } catch (NumberFormatException ex) {
            statusLine.setStatus("Cannot parse `" + frequencyTextField.getText() + "'");
        }
    }

    private void updateFromFrequencycode() {
        try {
            int freq = (int) Pronto.frequency(Integer.parseInt(prontocodeTextField.getText(), 16));
            frequencyTextField.setText(Integer.toString(freq));
            updateFromFrequency(freq);
        } catch (NumberFormatException | InvalidArgumentException ex) {
            statusLine.setStatus("Cannot parse `" + prontocodeTextField.getText() + "'");
        }
    }

    private void updateFromFrequency(double freq) {
        int time = Integer.parseInt(timeTextField.getText());
        noPeriodsTextField.setText(String.format("%.1f", (time * freq) / 1000000.0));
        statusLine.setStatus(null);
    }

    private void selectPeriodTime(boolean selectPeriod, boolean useHex) {
        noPeriodsTextField.setEditable(selectPeriod && ! useHex);
        noPeriodsHexTextField.setEditable(selectPeriod && useHex);
        timeTextField.setEditable(!selectPeriod);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        copyPastePopupMenu = new org.harctoolbox.guicomponents.CopyPastePopupMenu(true);
        jLabel24 = new javax.swing.JLabel();
        frequencyTextField = new javax.swing.JTextField();
        prontocodeTextField = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        timeTextField = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        noPeriodsHexTextField = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        noPeriodsTextField = new javax.swing.JTextField();
        statusLine = new org.harctoolbox.guicomponents.StatusLine();

        jLabel24.setText("Time (microseconds)");

        frequencyTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        frequencyTextField.setText("40000");
        frequencyTextField.setToolTipText("Enter modulation frequency here, then press return.");
        frequencyTextField.setMinimumSize(new java.awt.Dimension(100, 27));
        frequencyTextField.setPreferredSize(new java.awt.Dimension(100, 27));
        frequencyTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                frequencyTextFieldgenericCopyPasteMenu(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                frequencyTextFieldgenericCopyPasteMenu1(evt);
            }
        });
        frequencyTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frequencyTextFieldActionPerformed(evt);
            }
        });
        frequencyTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                frequencyTextFieldFocusLost(evt);
            }
        });

        prontocodeTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        prontocodeTextField.setText("0");
        prontocodeTextField.setToolTipText("Enter Pronto frequency code here, then press return.");
        prontocodeTextField.setMinimumSize(new java.awt.Dimension(100, 27));
        prontocodeTextField.setPreferredSize(new java.awt.Dimension(100, 27));
        prontocodeTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                prontocodeTextFieldgenericCopyPasteMenu(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                prontocodeTextFieldgenericCopyPasteMenu1(evt);
            }
        });
        prontocodeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prontocodeTextFieldActionPerformed(evt);
            }
        });
        prontocodeTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                prontocodeTextFieldFocusLost(evt);
            }
        });

        jLabel23.setText("# Periods (dec)");

        jLabel39.setText("hex");

        timeTextField.setEditable(false);
        timeTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        timeTextField.setText("0");
        timeTextField.setToolTipText("Duration in microseconds");
        timeTextField.setMinimumSize(new java.awt.Dimension(100, 27));
        timeTextField.setPreferredSize(new java.awt.Dimension(100, 27));
        timeTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                timeTextFieldMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                timeTextFieldgenericCopyPasteMenu(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                timeTextFieldgenericCopyPasteMenu1(evt);
            }
        });
        timeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeTextFieldActionPerformed(evt);
            }
        });
        timeTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                timeTextFieldFocusLost(evt);
            }
        });

        jLabel25.setText("Pronto");

        noPeriodsHexTextField.setEditable(false);
        noPeriodsHexTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        noPeriodsHexTextField.setText("1");
        noPeriodsHexTextField.setToolTipText("Click to enable");
        noPeriodsHexTextField.setMinimumSize(new java.awt.Dimension(100, 27));
        noPeriodsHexTextField.setPreferredSize(new java.awt.Dimension(100, 27));
        noPeriodsHexTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                noPeriodsHexTextFieldMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                noPeriodsHexTextFieldgenericCopyPasteMenu(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                noPeriodsHexTextFieldgenericCopyPasteMenu1(evt);
            }
        });
        noPeriodsHexTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noPeriodsHexTextFieldActionPerformed(evt);
            }
        });
        noPeriodsHexTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                noPeriodsHexTextFieldFocusLost(evt);
            }
        });

        jLabel22.setText("Freq. (Hz)");

        noPeriodsTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        noPeriodsTextField.setText("1");
        noPeriodsTextField.setToolTipText("Number of periods in selected frequency");
        noPeriodsTextField.setMinimumSize(new java.awt.Dimension(100, 27));
        noPeriodsTextField.setPreferredSize(new java.awt.Dimension(100, 27));
        noPeriodsTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                noPeriodsTextFieldMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                noPeriodsTextFieldgenericCopyPasteMenu(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                noPeriodsTextFieldgenericCopyPasteMenu1(evt);
            }
        });
        noPeriodsTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noPeriodsTextFieldActionPerformed(evt);
            }
        });
        noPeriodsTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                noPeriodsTextFieldFocusLost(evt);
            }
        });

        statusLine.setText("statusLine1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(frequencyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(noPeriodsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel22))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(prontocodeTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(noPeriodsHexTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(timeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 25, Short.MAX_VALUE))
                    .addComponent(statusLine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel25))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(frequencyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prontocodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noPeriodsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noPeriodsHexTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(statusLine, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void frequencyTextFieldgenericCopyPasteMenu(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frequencyTextFieldgenericCopyPasteMenu
        if (evt.isPopupTrigger())
        copyPastePopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_frequencyTextFieldgenericCopyPasteMenu

    private void frequencyTextFieldgenericCopyPasteMenu1(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frequencyTextFieldgenericCopyPasteMenu1
        if (evt.isPopupTrigger())
        copyPastePopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_frequencyTextFieldgenericCopyPasteMenu1

    private void frequencyTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frequencyTextFieldActionPerformed
        updateFromFrequency();
    }//GEN-LAST:event_frequencyTextFieldActionPerformed

    private void frequencyTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_frequencyTextFieldFocusLost
        updateFromFrequency();
    }//GEN-LAST:event_frequencyTextFieldFocusLost

    private void prontocodeTextFieldgenericCopyPasteMenu(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prontocodeTextFieldgenericCopyPasteMenu
        if (evt.isPopupTrigger())
        copyPastePopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_prontocodeTextFieldgenericCopyPasteMenu

    private void prontocodeTextFieldgenericCopyPasteMenu1(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prontocodeTextFieldgenericCopyPasteMenu1
        if (evt.isPopupTrigger())
        copyPastePopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_prontocodeTextFieldgenericCopyPasteMenu1

    private void prontocodeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prontocodeTextFieldActionPerformed
        updateFromFrequencycode();
    }//GEN-LAST:event_prontocodeTextFieldActionPerformed

    private void prontocodeTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_prontocodeTextFieldFocusLost
        updateFromFrequencycode();
    }//GEN-LAST:event_prontocodeTextFieldFocusLost

    private void timeTextFieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timeTextFieldMouseEntered
        selectPeriodTime(false, false);
    }//GEN-LAST:event_timeTextFieldMouseEntered

    private void timeTextFieldgenericCopyPasteMenu(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timeTextFieldgenericCopyPasteMenu
        if (evt.isPopupTrigger())
        copyPastePopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_timeTextFieldgenericCopyPasteMenu

    private void timeTextFieldgenericCopyPasteMenu1(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timeTextFieldgenericCopyPasteMenu1
        if (evt.isPopupTrigger())
        copyPastePopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_timeTextFieldgenericCopyPasteMenu1

    private void timeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeTextFieldActionPerformed
        try {
            int time = Integer.parseInt(timeTextField.getText());
            int freq = Integer.parseInt(frequencyTextField.getText());
            double periods = (time * ((double) freq)) / 1000000;
            noPeriodsTextField.setText(String.format("%.1f", periods));
            noPeriodsHexTextField.setText(String.format("%04X", Math.round(periods)));
        } catch (NumberFormatException ex) {
            statusLine.setStatus("Cannot parse `" + timeTextField.getText() + "'");
        }
    }//GEN-LAST:event_timeTextFieldActionPerformed

    private void timeTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_timeTextFieldFocusLost
        timeTextFieldActionPerformed(null);
    }//GEN-LAST:event_timeTextFieldFocusLost

    private void noPeriodsHexTextFieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noPeriodsHexTextFieldMouseEntered
        selectPeriodTime(true, true);
    }//GEN-LAST:event_noPeriodsHexTextFieldMouseEntered

    private void noPeriodsHexTextFieldgenericCopyPasteMenu(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noPeriodsHexTextFieldgenericCopyPasteMenu
        if (evt.isPopupTrigger())
        copyPastePopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_noPeriodsHexTextFieldgenericCopyPasteMenu

    private void noPeriodsHexTextFieldgenericCopyPasteMenu1(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noPeriodsHexTextFieldgenericCopyPasteMenu1
        if (evt.isPopupTrigger())
        copyPastePopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_noPeriodsHexTextFieldgenericCopyPasteMenu1

    private void noPeriodsHexTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noPeriodsHexTextFieldActionPerformed
        try {
            int noPeriods = Integer.parseInt(noPeriodsHexTextField.getText(), 16);
            noPeriodsTextField.setText(String.format("%d", noPeriods));
            int freq = Integer.parseInt(frequencyTextField.getText());
            timeTextField.setText(Integer.toString((int) (1000000 * ((double) noPeriods) / freq)));
        } catch (NumberFormatException ex) {
            statusLine.setStatus("Cannot parse `" + noPeriodsHexTextField.getText() + "'");
        }
    }//GEN-LAST:event_noPeriodsHexTextFieldActionPerformed

    private void noPeriodsHexTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_noPeriodsHexTextFieldFocusLost
        noPeriodsHexTextFieldActionPerformed(null);
    }//GEN-LAST:event_noPeriodsHexTextFieldFocusLost

    private void noPeriodsTextFieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noPeriodsTextFieldMouseEntered
        selectPeriodTime(true, false);
    }//GEN-LAST:event_noPeriodsTextFieldMouseEntered

    private void noPeriodsTextFieldgenericCopyPasteMenu(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noPeriodsTextFieldgenericCopyPasteMenu
        if (evt.isPopupTrigger())
        copyPastePopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_noPeriodsTextFieldgenericCopyPasteMenu

    private void noPeriodsTextFieldgenericCopyPasteMenu1(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noPeriodsTextFieldgenericCopyPasteMenu1
        if (evt.isPopupTrigger())
        copyPastePopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_noPeriodsTextFieldgenericCopyPasteMenu1

    private void noPeriodsTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noPeriodsTextFieldActionPerformed
        try {
            double noPeriods = Double.parseDouble(noPeriodsTextField.getText());
            noPeriodsHexTextField.setText(String.format("%04X", Math.round(noPeriods)));
            int freq = Integer.parseInt(frequencyTextField.getText());
            timeTextField.setText(Integer.toString((int) (seconds2microseconds * noPeriods / freq)));
        } catch (NumberFormatException ex) {
            statusLine.setStatus("Cannot parse `" + noPeriodsTextField.getText() + "'");
        }
    }//GEN-LAST:event_noPeriodsTextFieldActionPerformed

    private void noPeriodsTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_noPeriodsTextFieldFocusLost
        noPeriodsTextFieldActionPerformed(null);
    }//GEN-LAST:event_noPeriodsTextFieldFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.harctoolbox.guicomponents.CopyPastePopupMenu copyPastePopupMenu;
    private javax.swing.JTextField frequencyTextField;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JTextField noPeriodsHexTextField;
    private javax.swing.JTextField noPeriodsTextField;
    private javax.swing.JTextField prontocodeTextField;
    private org.harctoolbox.guicomponents.StatusLine statusLine;
    private javax.swing.JTextField timeTextField;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getHelpMessage() {
        return helpText;
    }

    @Override
    public String getAboutMessage() {
        return aboutText;
    }

    @Override
    public String getProgName() {
        return "TimeFrequencyCalculator";
    }

    @Override
    public String getIconPath() {
        return "/icons/Crystal-Clear/22x22/apps/xclock.png";
    }

    @Override
    public void close() throws IOException {
    }
}