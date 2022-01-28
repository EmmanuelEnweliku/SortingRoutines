/*
  Name: Emmanuel Enweliku.
  Date: 25/1/2022.           //Note: The format for date is Day/Month/Year.
  Title: SortingRoutines.
  Purpose: Write a program that will sort a list of random numbers. The random numbers should be in the range from -1000 to 1000. 
           The user should have the choice of: which sorting algorithm to use to sort the numbers, 
           how many numbers are to be sorted in the list, whether the list is sorted in ascending or descending order e.t.c.
*/
package sortingroutines.sortingroutines;

import javax.swing.*;

import java.util.*;

import java.awt.event.*;

public class SortingRoutines 
{
    static String numPrint = " ", numPrint1 = " ", numPrint2 = " ", numPrint3 = " ", numPrint4 = " ", numPrint5 = " ", numPrint6 = " ";
    static int num, num1;
    static JTextField txtInput, txtInput1, txtInput2;
    static JRadioButton selection, bubble, insertion, shell, cocktail, counting, ascending, descending;
    static JLabel lblOutput, lblOutput1, lblInfo, lblInfo1, lblInfo2, lblInfo3, lblInfo4, lblInfo5;
    static JButton btnProcess;
    static ButtonGroup sort, sortOrder;

    private static void guiApp() 
    {
        //Create and set up the window
        JFrame frame = new JFrame("SortingRoutines");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        lblInfo = new JLabel("Enter the following information:");
        lblInfo1 = new JLabel("Sorting Algorithm:");
        lblInfo2 = new JLabel("Sort Order:");
        lblInfo3 = new JLabel("Amount of numbers to sort:");
        lblInfo4 = new JLabel("NOTE! Code wil not run unless both a sorting algorithm and order is selected");
        lblInfo5 = new JLabel("Please Exit the SortingRoutines app after sorting is complete before further use");
        txtInput = new JTextField();
        txtInput1 = new JTextField();
        txtInput2 = new JTextField();

        //Set up JRadioButtons
        selection = new JRadioButton("Selection", false);
        bubble = new JRadioButton("Bubble", false);
        insertion = new JRadioButton("Insertion", false);
        shell = new JRadioButton("Shell", false);
        cocktail = new JRadioButton("Cocktail", false);
        counting = new JRadioButton("Coutning", false);

        ascending = new JRadioButton("Ascending", false);
        //ascending.setHorizontalTextPosition(SwingConstants.RIGHT);

        descending = new JRadioButton("Descending", false);
        //descending.setHorizontalTextPosition(SwingConstants.RIGHT);

        //Set up group relationship for the various sort
        sort = new ButtonGroup();
        sort.add(selection);
        sort.add(bubble);
        sort.add(insertion);
        sort.add(shell);
        sort.add(cocktail);
        sort.add(counting);

        //set up group relationship for the various sortOrder
        sortOrder = new ButtonGroup();
        sortOrder.add(ascending);
        sortOrder.add(descending);

        //Set up JButton and output label
        btnProcess = new JButton("Sort Numbers");
        lblOutput = new JLabel("Original Numbers:");
        lblOutput1 = new JLabel("Sorted Numbers:");

        //Create new ButtonHandler instance
        ButtonHandler onClick = new ButtonHandler();
        btnProcess.addActionListener(onClick);

        //Add components to panel
        panel.add(lblInfo);
        panel.add(lblInfo1);
        panel.add(selection);
        panel.add(bubble);
        panel.add(insertion);
        panel.add(shell);
        panel.add(cocktail);
        panel.add(counting);

        panel.add(lblInfo2);
        panel.add(ascending);
        panel.add(descending);

        panel.add(lblInfo3);
        panel.add(txtInput);
        
        panel.add(lblInfo4);
        panel.add(btnProcess);

        panel.add(lblOutput);
        panel.add(txtInput1);

        panel.add(lblOutput1);
        panel.add(txtInput2);
        panel.add(lblInfo5);

        //Add panel and panel1 to frame
        frame.getContentPane().add(panel);

        //Display the window
        frame.pack();
        frame.setVisible(true);
    }

    //Mouse Click Handler
    private static class ButtonHandler implements ActionListener 
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            //get amount to sort data
            String data = txtInput.getText();
            //parse for numerical value
            num = Integer.parseInt(data);  //The String(data) turns to an int(num) //Max value f

            int[] array = new int[num];  //Array.

            int min = 1000; //Minimum value for the range
            int max = 1000;  //Maximum value for the range

            Random rand = new Random();

            for (int n = 0; n < array.length; n++) 
            {
                array[n] = rand.nextInt((max + min) - min); //Storing random numbers in array
                numPrint = numPrint + " " + array[n];  //numPrint is a String.
            }

            txtInput1.setText(numPrint); //displays random numbers

            //Remember to add comments to parts of code that need explaining.
            if (selection.isSelected() && ascending.isSelected()) 
            {
                // selection sort = SS   is complete
                String[] inputs = txtInput1.getText().trim().split(" ");

                int[] array1 = new int[inputs.length];

                for (int i = 0; i < inputs.length; i++) 
                {
                    String input = inputs[i];
                    array1[i] = Integer.parseInt(input.trim());
                }

                int LLSS = inputs.length;//Ask marvin to explain this to you. When array1.lengtth was there it didn't sort until i changed it to inputs.length

                for (int i = 0; i < LLSS - 1; i++) 
                {
                    int minIndex = i;
                    for (int j = i + 1; j < LLSS; j++) 
                    {
                        if (array1[j] < array1[minIndex]) 
                        {
                            minIndex = j;
                        }
                        int te = array1[minIndex];
                        array1[minIndex] = array1[i];
                        array1[i] = te;
                    }
                }
                
                //Output
                for (int i = 0; i < LLSS; i++) 
                {
                    numPrint1 = numPrint1 + " " + array1[i];
                }
                txtInput2.setText(numPrint1);
            }
            else if(selection.isSelected() && descending.isSelected())
            {
                // reverse selection sort = SS   is complete
                String[] inputs = txtInput1.getText().trim().split(" ");

                int[] array1 = new int[inputs.length];

                for (int i = 0; i < inputs.length; i++) 
                {
                    String input = inputs[i];
                    array1[i] = Integer.parseInt(input.trim());
                }

                int LLSS = inputs.length;

                for (int i = 0; i < LLSS - 1; i++) 
                {
                    int minIndex = i;
                    for (int j = i + 1; j < LLSS; j++) 
                    {
                        if (array1[j] > array1[minIndex]) 
                        {
                            minIndex = j;
                        }
                        int te = array1[minIndex];
                        array1[minIndex] = array1[i];
                        array1[i] = te;
                    }
                }
                
                //Output
                for (int i = 0; i < LLSS; i++) 
                {
                    numPrint1 = numPrint1 + " " + array1[i];
                }
                txtInput2.setText(numPrint1);
            }
            
            if (bubble.isSelected() && ascending.isSelected()) 
            {
                //bubble sort = BS   is complete
                String[] inputs = txtInput1.getText().trim().split(" ");

                int[] array2 = new int[inputs.length];

                for (int i = 0; i < inputs.length; i++) 
                {
                    String input = inputs[i];
                    array2[i] = Integer.parseInt(input.trim());
                }

                int LLBS = inputs.length;

                for (int i = 0; i < LLBS - 1; i++) 
                {
                    for (int j = 0; j < LLBS - i - 1; j++) 
                    {
                        if (array2[j] > array2[j + 1]) 
                        {
                            int te = array2[j];
                            array2[j] = array2[j + 1];
                            array2[j + 1] = te;
                        }
                    }
                }
                
                //Output
                for (int i = 0; i < LLBS; i++) 
                {
                    numPrint2 = numPrint2 + " " + array2[i];
                }
                txtInput2.setText(numPrint2);
            }
            else if(bubble.isSelected() && descending.isSelected())
            {
                // reverse bubble sort = BS   is complete
                String[] inputs = txtInput1.getText().trim().split(" ");

                int[] array2 = new int[inputs.length];

                for (int i = 0; i < inputs.length; i++) 
                {
                    String input = inputs[i];
                    array2[i] = Integer.parseInt(input.trim());
                }

                int LLBS = inputs.length;

                for (int i = 0; i < LLBS - 1; i++) 
                {
                    for (int j = 0; j < LLBS - i - 1; j++) 
                    {
                        if (array2[j] < array2[j + 1]) 
                        {
                            int te = array2[j];
                            array2[j] = array2[j + 1];
                            array2[j + 1] = te;
                        }
                    }
                }
                
                //Output
                for (int i = 0; i < LLBS; i++) 
                {
                    numPrint2 = numPrint2 + " " + array2[i];
                }
                txtInput2.setText(numPrint2);
            }
            
            
            if (insertion.isSelected() && ascending.isSelected()) 
            {
                //insertion sort = IS  is complete
                String[] inputs = txtInput1.getText().trim().split(" ");

                int[] array3 = new int[inputs.length];

                for (int i = 0; i < inputs.length; i++) 
                {
                    String input = inputs[i];
                    array3[i] = Integer.parseInt(input.trim());
                }

                int LLIS = inputs.length;

                for (int i = 1; i < LLIS; i++) 
                {
                    int key = array3[i];
                    int j = i - 1;

                    while (j >= 0 && array3[j] > key) 
                    {
                        array3[j + 1] = array3[j];
                        j = j - 1;
                    }
                    array3[j + 1] = key;
                }
                
                //Output
                for (int i = 0; i < LLIS; i++) 
                {
                    numPrint3 = numPrint3 + " " + array3[i];
                }
                txtInput2.setText(numPrint3);
            }
            else if(insertion.isSelected() && descending.isSelected())
            {
                //reverse insertion sort = IS  is complete
                String[] inputs = txtInput1.getText().trim().split(" ");

                int[] array3 = new int[inputs.length];

                for (int i = 0; i < inputs.length; i++) 
                {
                    String input = inputs[i];
                    array3[i] = Integer.parseInt(input.trim());
                }

                int LLIS = inputs.length;

                for (int i = 1; i < LLIS; i++) 
                {
                    int key = array3[i];
                    int j = i - 1;

                    while (j >= 0 && array3[j] < key) 
                    {
                        array3[j + 1] = array3[j];
                        j = j - 1;
                    }
                    array3[j + 1] = key;
                }
                
                //Output
                for (int i = 0; i < LLIS; i++) 
                {
                    numPrint3 = numPrint3 + " " + array3[i];
                }
                txtInput2.setText(numPrint3);
            }
            
            if (shell.isSelected() && ascending.isSelected()) 
            {
                //shell sort = SHS  is complete
                String[] inputs = txtInput1.getText().trim().split(" ");
                
                int[] array4 = new int[inputs.length];
                
                for (int i = 0; i < inputs.length; i++)
                {
                    String input = inputs[i];
                    array4[i] = Integer.parseInt(input.trim());
                }
                
                int LLSHS = inputs.length;

                for (int gap = LLSHS / 2; gap > 0; gap /= 2) 
                {
                    for (int i = gap; i < LLSHS; i += 1) 
                    {
                        int temp = array4[i];
                        int j;
                        for (j = i; j >= gap && array4[j - gap] > temp; j -= gap) 
                        {
                            array4[j] = array4[j - gap];
                        }
                        array4[j] = temp;
                    }
                }
                
                //Output
                for (int i = 0; i < LLSHS; ++i) 
                {
                    numPrint4 = numPrint4 + " " + array4[i];
                }
                txtInput2.setText(numPrint4);
            }
            else if(shell.isSelected() && descending.isSelected())
            {
                // reverse shell sort = SHS  is complete
                String[] inputs = txtInput1.getText().trim().split(" ");
                
                int[] array4 = new int[inputs.length];
                
                for (int i = 0; i < inputs.length; i++)
                {
                    String input = inputs[i];
                    array4[i] = Integer.parseInt(input.trim());
                }
                
                int LLSHS = inputs.length;

                for (int gap = LLSHS / 2; gap > 0; gap /= 2) 
                {
                    for (int i = gap; i < LLSHS; i += 1) 
                    {
                        int temp = array4[i];
                        int j;
                        for (j = i; j >= gap && array4[j - gap] < temp; j -= gap) 
                        {
                            array4[j] = array4[j - gap];
                        }
                        array4[j] = temp;
                    }
                }
                
                //Output
                for (int i = 0; i < LLSHS; ++i) 
                {
                    numPrint4 = numPrint4 + " " + array4[i];
                }
                txtInput2.setText(numPrint4);
            }
           
            
            if (cocktail.isSelected() && ascending.isSelected()) 
            {
                //cocktail sort = CS  is complete.
                String[] inputs = txtInput1.getText().trim().split(" ");
                
                int[] array5 = new int[inputs.length];
                
                for (int i = 0; i < inputs.length; i++)
                {
                    String input = inputs[i];
                    array5[i] = Integer.parseInt(input.trim());
                }
                
                
                int LLCS = inputs.length;   //end
                boolean swapped = true;
                int start = 0;   //start

                while (swapped == true) 
                {
                    /*
                      Reset the swapped flag on entering the loop, because it 
                      might be true from a previous iteration.
                    */
                    swapped = false;
                    
                    //Loop from bottom to top same as the bubble sort.
                    for (int i = 0; i < LLCS - 1; ++i) 
                    {
                        if (array5[i] > array5[i + 1]) 
                        {
                            int temp = array5[i];
                            array5[i] = array5[i + 1];
                            array5[i + 1] = temp;
                            swapped = true;
                        }
                    }
                    //if nothing moved, then array is sorted.
                    if (swapped == false) 
                    {
                        break;
                    }
                    
                    /*
                      Otherwise, reset the swapped flag so that it can be used 
                      in the next stage.
                    */
                    swapped = false;
                    
                    /*
                      Move the end point back by one, because item at the end 
                      is in its rightful spot.
                    */
                    LLCS = LLCS-1 ;
                    
                    /*
                      From top to botton, doing the same comparison as in 
                      the previous stage.
                    */
                    for (int i = LLCS - 1; i >= 0; i--) 
                    {
                        if (array5[i] > array5[i + 1]) 
                        {
                            int temp = array5[i];
                            array5[i] = array5[i + 1];
                            array5[i + 1] = temp;
                            swapped = true;
                        }
                    }
                    /*
                      Increase the starting point, because the last stage would 
                      have moved the next smallest number to its rightful spot
                    */
                    start = start + 1;
                }
                
                //Output
                for (int i = 0; i < array5.length; i++) 
                {
                    numPrint5 = numPrint5 + " * " + array5[i];
                    
                    System.out.print(array5[i]+" ");
                
                }
                txtInput2.setText(numPrint5);
            }
            else if(cocktail.isSelected() && descending.isSelected())
            {
                // reverse cocktail sort = CS  is complete.
                String[] inputs = txtInput1.getText().trim().split(" ");
                
                int[] array5 = new int[inputs.length];
                
                for (int i = 0; i < inputs.length; i++)
                {
                    String input = inputs[i];
                    array5[i] = Integer.parseInt(input.trim());
                }
                
                
                int LLCS = inputs.length;   //end
                boolean swapped = true;
                int start = 0;   //start

                while (swapped == true) 
                {
                    /*
                      Reset the swapped flag on entering the loop, because it 
                      might be true from a previous iteration.
                    */
                    swapped = false;
                    
                    //Loop from bottom to top same as the bubble sort.
                    for (int i = 0; i < LLCS - 1; ++i) 
                    {
                        if (array5[i] < array5[i + 1]) 
                        {
                            int temp = array5[i];
                            array5[i] = array5[i + 1];
                            array5[i + 1] = temp;
                            swapped = true;
                        }
                    }
                    //if nothing moved, then array is sorted.
                    if (swapped == false) 
                    {
                        break;
                    }
                    
                    /*
                      Otherwise, reset the swapped flag so that it can be used 
                      in the next stage.
                    */
                    swapped = false;
                    
                    /*
                      Move the end point back by one, because item at the end 
                      is in its rightful spot.
                    */
                    LLCS = LLCS-1 ;
                    
                    /*
                      From top to botton, doing the same comparison as in 
                      the previous stage.
                    */
                    for (int i = LLCS - 1; i >= 0; i--) 
                    {
                        if (array5[i] < array5[i + 1]) 
                        {
                            int temp = array5[i];
                            array5[i] = array5[i + 1];
                            array5[i + 1] = temp;
                            swapped = true;
                        }
                    }
                    /*
                      Increase the starting point, because the last stage would 
                      have moved the next smallest number to its rightful spot
                    */
                    start = start + 1;
                }
                
                //Output
                for (int i = 0; i < array5.length; i++) 
                {
                    numPrint5 = numPrint5 + " " + array5[i];
                    
                    System.out.print(array5[i]+" ");
                
                }
                txtInput2.setText(numPrint5);
            }
            
            
            if (counting.isSelected() && ascending.isSelected()) 
            {
                //counting sort = COS  is complete
                String[] inputs = txtInput1.getText().trim().split(" ");
                
                int[] array6 = new int[inputs.length];
                
                for (int i = 0; i < inputs.length; i++)
                {
                    String input = inputs[i];
                    array6[i] = Integer.parseInt(input.trim());
                }
                
                int LLNS = inputs.length;

                int maxNS = Arrays.stream(array6).max().getAsInt();
                int minNS = Arrays.stream(array6).min().getAsInt();
                int range = maxNS - minNS + 1;
                int count[] = new int[range];
                int output[] = new int[LLNS];

                for (int i = 0; i < LLNS; i++) 
                {
                    count[array6[i] - minNS]++;
                }

                for (int i = 1; i < count.length; i++) 
                {
                    count[i] += count[i - 1];
                }

                for (int i = LLNS - 1; i >= 0; i--) 
                {
                    output[count[array6[i] - minNS] - 1] = array6[i];
                    count[array6[i] - minNS]--;
                }

                for (int i = 0; i < LLNS; i++) 
                {
                    array6[i] = output[i];
                }
                
                //Output
                for (int i = 0; i < LLNS; i++) 
                {
                    numPrint6 = numPrint6 + " " + array6[i];
                }
                txtInput2.setText(numPrint6);
            }
            else if(counting.isSelected() && descending.isSelected())
            {
                // reverse counting sort = COS  is not complete
                String[] inputs = txtInput1.getText().trim().split(" ");
                
                int[] array6 = new int[inputs.length];
                
                for (int i = 0; i < inputs.length; i++)
                {
                    String input = inputs[i];
                    array6[i] = Integer.parseInt(input.trim());
                }
                
                int LLNS = inputs.length;

                int maxNS = Arrays.stream(array6).max().getAsInt();
                int minNS = Arrays.stream(array6).min().getAsInt();
                int range = maxNS - minNS + 1;
                int count[] = new int[range];
                int output[] = new int[LLNS];

                for (int i = 0; i < LLNS; i++) 
                {
                    count[array6[i] - minNS]++;
                }

                for (int i = 1; i < count.length; i++) 
                {
                    count[i] += count[i - 1];
                }

                for (int i = LLNS - 1; i >= 0; i--) 
                {
                    output[count[array6[i] - minNS] - 1] = array6[i];
                    count[array6[i] - minNS]--;
                }

                for (int i = 0; i < LLNS; i++) 
                {
                    array6[i] = output[i];
                }
                
                //Output
                for (int i = 0; i < LLNS; i++) 
                {
                    numPrint6 = numPrint6 + " " + array6[i];
                }
                txtInput2.setText(numPrint6);
            }
            
        }
    }

    public static void main(String[] args) 
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                guiApp();
            }
        });
    }
}
