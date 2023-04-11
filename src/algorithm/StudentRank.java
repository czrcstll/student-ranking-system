
package algorithm;

import javax.swing.JOptionPane;

public class StudentRank extends javax.swing.JFrame {

    public StudentRank() {
        initComponents();
    }
    public void sort(int arr[], String names[], int n) 
    { 

        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, names, n, i); 
  
        // One by one extract an element from heap 
        for (int i=n-1; i>=0; i--) 
        { 
            // Move current root to end 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
            
             String tempN = names[0]; 
            names[0] = names[i]; 
            names[i] = tempN; 
  
            // call max heapify on the reduced heap 
            heapify(arr, names, i, 0); 
        } 
    } 
  
    // To heapify a subtree rooted with node i which is 
    // an index in arr[]. n is size of heap 
    void heapify(int arr[], String names[] , int n, int i) 
    { 
        int largest = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && arr[l] < arr[largest]) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] < arr[largest]) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
            
             String swapN = names[i]; 
            names[i] = names[largest]; 
            names[largest] = swapN; 
  
            // Recursively heapify the affected sub-tree 
            heapify(arr, names, n ,largest); 
        } 
    } 
  
    /* A utility function to print array of size n */
     void printArray(int arr[], String names[], int n) 
    { 
        for (int i=0; i<n; ++i){
            System.out.print(names[i] + " " + arr[i]+ "\n"); 
            recordTextArea.append( (i+1)+ ". " + names[i] + "     " + arr[i]+ "\n");
            System.out.println(); 
        } 
    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        recordScrollPane = new javax.swing.JScrollPane();
        recordTextArea = new javax.swing.JTextArea();
        clear = new javax.swing.JButton();
        add = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        recordScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        recordTextArea.setEditable(false);
        recordTextArea.setColumns(20);
        recordTextArea.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        recordTextArea.setLineWrap(true);
        recordTextArea.setRows(5);
        recordScrollPane.setViewportView(recordTextArea);

        jPanel1.add(recordScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 300, 260));

        clear.setBorderPainted(false);
        clear.setContentAreaFilled(false);
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel1.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 590, 130, 30));

        add.setBorderPainted(false);
        add.setContentAreaFilled(false);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 590, 120, 30));

        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel1.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 0, 20, 30));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/algorithm/student.png"))); // NOI18N
        jPanel1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        int exit = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to exit?", "EXIT", JOptionPane.CANCEL_OPTION);
        if(exit == 0){
            this.dispose();
    }//GEN-LAST:event_exitActionPerformed
    }
    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
       recordTextArea.selectAll();
       recordTextArea.replaceSelection("");
       
    }//GEN-LAST:event_clearActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
         int numOfStudents = Integer.parseInt(JOptionPane.showInputDialog(rootPane, "Enter number of Students"));
         int arr[] = new int[numOfStudents]; 
        
        String names[] = new String[numOfStudents];
        int n = arr.length; 
        for(int i = 0; i< numOfStudents; i++){
            String name = JOptionPane.showInputDialog(rootPane, "Input student name: ");
                names[i] = name;
                
            
              int grade = Integer.parseInt(JOptionPane.showInputDialog(rootPane, "Input student grade: "));
                 arr[i] = grade;
        }
            
        StudentRank ob = new StudentRank(); 
        ob.sort(arr, names, n); 
        
  
        System.out.println("Sorted array is"); 
        printArray(arr, names, n); 
    }//GEN-LAST:event_addActionPerformed
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentRank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentRank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentRank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentRank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                StudentRank run = new StudentRank();
                run.setVisible(true);
                run.setResizable(false);
                run.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JLabel bg;
    private javax.swing.JButton clear;
    private javax.swing.JButton exit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane recordScrollPane;
    private javax.swing.JTextArea recordTextArea;
    // End of variables declaration//GEN-END:variables
}
