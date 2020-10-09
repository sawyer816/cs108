

System.out.println("Are you an existing customer? [Y: Yes; N: No]");
        Scanner input = new Scanner(System.in);
        if (input.nextLine().equalsIgnoreCase("Y")) {
        System.out.println("Enter Customer ID:");
        String id = input.nextLine();
        Customer oldCustomer = new Customer(id);