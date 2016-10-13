package edu.avans.library.domain;

import java.awt.datatransfer.Transferable;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Avans Java Proftaak
 * @author Daniel van Willigen
 * @version 1.0
 */

public abstract class DropTargetArea extends JPanel implements DropTargetListener {
    
    public DropTargetArea() {
    new DropTarget(this, this);
    }

    @Override
    public void dragEnter(DropTargetDragEvent evt) {
    }

    @Override
    public void dragOver(DropTargetDragEvent evt) {
    }

    @Override
    public void dragExit(DropTargetEvent evt) {
    }

    @Override
    public void dropActionChanged(DropTargetDragEvent evt) {
    }

    @Override
    public void drop(DropTargetDropEvent evt) {
    Transferable transferable = evt.getTransferable();
    JOptionPane.showMessageDialog(null,"Yes");
    }
}