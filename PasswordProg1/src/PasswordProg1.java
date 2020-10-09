
public class PasswordProg1 {
    String[][] studentPasswords;
    // 2D class instance variable declaration here--just the data type and name

    /**
     * Constructor
     */
    public PasswordProg1(String[] passwords) {
        studentPasswords= new String[3][passwords.length];
        for (int i = 0; i < studentPasswords.length; i++) {
            for (int j = 0; j < 4; j++) {
                studentPasswords[i][j]=passwords[i*4+j];
            }
        }
    }
        public boolean hasWord (String password)
        {
            for (int i = 0; i < studentPasswords.length; i++) {
                for (int j = 0; j < studentPasswords[i].length/3; j++) {
                    if(studentPasswords[i][j].equals(password))
                    {
                        return true;
                    }
                }
            }
            return false;
        }

        public void unlockAll ()
        {
            for (int i = 0; i < studentPasswords.length; i++) {
                for (int j = 0; j < studentPasswords[i].length; j++) {
                    studentPasswords[i][j]= "unlock";
                }
            }
        }

        public String longest ()
        {
            String longest = "";
            for (int i = 0; i < studentPasswords.length; i++) {
                for (int j = 0; j < 4; j++) {
                    if(studentPasswords[i][j].length()>longest.length())
                    {
                        longest=studentPasswords[i][j];
                    }
                }
            }
            return longest;
        }

        public int mostFrequent () {
            int frequent=0;
            int index = 0;
            int count=0;
            for (int i = 0; i < studentPasswords.length;i++) {
                frequent=0;
                for (int j = 0; j < 4-1; j++) {
                    {
                        if (!studentPasswords[i][j].equals(studentPasswords[i][j+1])) {
                            frequent++;
                        }
                    }
                }
                if (frequent > count) {
                    count=frequent;
                    index = i;
                }
            }
            return index;
        }

        public String getIdentificationString ()
        {
            return "Program 1, Sawyer Thompson";
        }

        public static void main (String[]args){
        String[] a = {"1", "1", "student1", "s1", "student2", "s", "student", "s2",
                "student3", "s3", "student3", "s3"};
        PasswordProg1 he = new PasswordProg1(a);
        System.out.println(he.hasWord("c"));
            System.out.println(he.mostFrequent());
        }

}


