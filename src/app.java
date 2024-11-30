package src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class app extends JFrame{
    //jframe size
    private static final int WIDTH = 620;
    private static final int HEIGHT = 800;
    //panels
    JPanel homePanel;
    JPanel bubbleSortPanel;
    JPanel selectionSortPanel;

    //listeners to Menu item choice selected by user
    private class BubbleSortListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            homePanel.setVisible(false);
            bubbleSortPanel.setVisible(true);
            selectionSortPanel.setVisible(false);
        }
    }//end of BubbleSortListener inner class
    private class HomePanelListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            homePanel.setVisible(true);
            bubbleSortPanel.setVisible(false);
            selectionSortPanel.setVisible(false);
        }
    }//end of HomePanelListener inner class
    private class SelectionSortPanelListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            homePanel.setVisible(false);
            bubbleSortPanel.setVisible(false);
            selectionSortPanel.setVisible(true);
        }
    }//end of selectionSortPanelListener inner class

    public app(){
        //required to create JFrame
        super("Sorting Algorithms");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        //makes the home panel
        JLabel welcomeInfo = new JLabel("Selamat Datang ke Aplikasi Visualisasi Algoritma Bubble Sort dan Selection Sort");
        homePanel = new JPanel();
        homePanel.setLayout(new BorderLayout());
        homePanel.add(welcomeInfo, BorderLayout.NORTH);
        homePanel.setVisible(true);
        add(homePanel);

        //makes the bubble sort panel
        bubbleSortPanel = bubbleSorter.runBubbleSort();
        bubbleSortPanel.setVisible(false);
        add(bubbleSortPanel);

        //makes the selection sort panel
        selectionSortPanel = SelectionSorter.runSelectionSort();
        selectionSortPanel.setVisible(false);
        add(selectionSortPanel);

        //makes menu
        JMenu menu = new JMenu("Menu");
        //adds all menu items
        JMenuItem homeChoice = new JMenuItem("Home");
        homeChoice.addActionListener(new HomePanelListener());
        menu.add(homeChoice);
        JMenuItem bubbleChoice = new JMenuItem("Bubble Sort");
        bubbleChoice.addActionListener(new BubbleSortListener());
        menu.add(bubbleChoice);
        JMenuItem selectionChoice = new JMenuItem("Selection Sort");
        selectionChoice.addActionListener(new SelectionSortPanelListener());
        menu.add(selectionChoice);

        //creates the menu bar
        JMenuBar bar = new JMenuBar();
        bar.add(menu);
        setJMenuBar(bar);
    }

    public static void main(String[] args){
        app gui = new app();
        gui.setVisible(true);
    }
}