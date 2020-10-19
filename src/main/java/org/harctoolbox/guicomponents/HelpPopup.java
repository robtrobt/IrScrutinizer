/*
Copyright (C) 2012, 2013 Bengt Martensson.

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

import java.awt.Desktop;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import org.harctoolbox.ircore.ThisCannotHappenException;

/**
 * A class for help popups.
 */
public class HelpPopup extends javax.swing.JDialog {
    private final String payload;
    private final GuiUtils guiUtils;

    /**
     * Creates a help popup.
     *
     * @param parent Parent window
     * @param helpText Text (one string, to be formatted to many lines) containing the messages.
     * @param title
     */
    public HelpPopup(Window parent, String helpText, String title) {
        super(parent, title);
        payload = helpText;
        this.guiUtils = new GuiUtils(this);
        initComponents();
        // show the start of the text
        this.helpText.setCaretPosition(0);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        copyMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        printMenuItem = new javax.swing.JMenuItem();
        closeMenuItem = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        helpText = new javax.swing.JTextArea();

        copyMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Crystal-Clear/22x22/actions/editcopy.png"))); // NOI18N
        copyMenuItem.setMnemonic('C');
        copyMenuItem.setText("Copy");
        copyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyMenuItemActionPerformed(evt);
            }
        });
        jPopupMenu1.add(copyMenuItem);

        saveMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Crystal-Clear/22x22/actions/filesaveas.png"))); // NOI18N
        saveMenuItem.setMnemonic('S');
        saveMenuItem.setText("Save...");
        saveMenuItem.setToolTipText("Save to file.");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        jPopupMenu1.add(saveMenuItem);

        printMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Crystal-Clear/22x22/actions/fileprint.png"))); // NOI18N
        printMenuItem.setMnemonic('P');
        printMenuItem.setText("Print...");
        printMenuItem.setToolTipText("Send as text to printer.");
        printMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printMenuItemActionPerformed(evt);
            }
        });
        jPopupMenu1.add(printMenuItem);

        closeMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Crystal-Clear/22x22/actions/cancel.png"))); // NOI18N
        closeMenuItem.setText("Close");
        closeMenuItem.setToolTipText("Close this window.");
        closeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeMenuItemActionPerformed(evt);
            }
        });
        jPopupMenu1.add(closeMenuItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        helpText.setEditable(false);
        helpText.setColumns(20);
        helpText.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        helpText.setLineWrap(true);
        helpText.setRows(4);
        helpText.setText(payload);
        helpText.setToolTipText("Press menu mouse button for a context menu, or mouse button 2 to close.");
        helpText.setWrapStyleWord(true);
        helpText.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        helpText.setComponentPopupMenu(jPopupMenu1);
        helpText.setMargin(new java.awt.Insets(0, 10, 0, 0));
        helpText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpTextMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(helpText);
        helpText.getAccessibleContext().setAccessibleDescription("Press mouse button 2 or 3 to close window");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void copyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyMenuItemActionPerformed
        (new CopyClipboardText(null)).toClipboard(payload);
    }//GEN-LAST:event_copyMenuItemActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        try {
            File file = SelectFile.selectFile(this, "Save console text as...", null, true, false, "Text file", "txt");
            if (file != null)
                save(file);
        } catch (FileNotFoundException ex) {
            guiUtils.error(ex, "File not found");
        }
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void printMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printMenuItemActionPerformed
        File file;
        try {
            file = File.createTempFile("help", ".txt");
        } catch (IOException ex) {
            guiUtils.error(ex);
            return;
        }
        try (PrintStream pos = new PrintStream(new FileOutputStream(file), true, "UTF-8")) {
            pos.println(payload);
        } catch (IOException ex) {
            guiUtils.error(ex);
            return;
        }

        try {
            Desktop.getDesktop().print(file);
            file.deleteOnExit();
        } catch (UnsupportedOperationException ex) {
            guiUtils.error("Desktop does not support printing. Print the file "
                    + file.getAbsolutePath() + " manually.");
        } catch (IOException ex) {
            guiUtils.error(ex, "");
        }
    }//GEN-LAST:event_printMenuItemActionPerformed

    private void closeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeMenuItemActionPerformed
        dispose();
    }//GEN-LAST:event_closeMenuItemActionPerformed

    private void helpTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpTextMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON2)
            dispose();
    }//GEN-LAST:event_helpTextMouseClicked

    /**
     * Saves the console content as text to the file given as argument.
     * @param file
     * @throws FileNotFoundException
     */
    public void save(File file) throws FileNotFoundException {
        try (PrintStream ps = new PrintStream(new FileOutputStream(file), true,  "UTF-8")) {
            ps.println(payload);
        } catch (UnsupportedEncodingException ex) {
            throw new ThisCannotHappenException(ex);
        }
    }

    public static HelpPopup newHelpPopup(Window parent, String helpText) {
        return newHelpPopup(parent, helpText, "Help");
    }

    public static HelpPopup newHelpPopup(Window parent, String helpText, String title) {
        HelpPopup helpBox = new HelpPopup(parent, helpText, title);
        // Try to align just to the right of the parent
        Rectangle parentCoords = parent.getBounds();
        Rectangle myCoords = helpBox.getBounds();
        myCoords.x = parentCoords.x + parentCoords.width;
        myCoords.y = parentCoords.y;
        helpBox.setBounds(myCoords);
        helpBox.setVisible(true);
        return helpBox;
    }

   /**
    * Normally not used; just for debugging.
    *
    * @param args Not used.
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            HelpPopup dialog = new HelpPopup(new javax.swing.JFrame(), "The best defense against logic is ignorance.", "Helpful help");
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem closeMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JTextArea helpText;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem printMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables
}