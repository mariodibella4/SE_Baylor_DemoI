package Servicers;

import app.Clerk;

public class ClerksTable {
    public static Object[][] parseClerksList(){
        Object[][] tm = new Object[Clerk.getRegisteredClerks().size()][4];

        for(int i = 0; i < Clerk.getRegisteredClerks().size(); i++)
        {
            tm[i][0] = Clerk.getRegisteredClerks().get(i).getClerkID();
            tm[i][1] = Clerk.getRegisteredClerks().get(i).getFirstName();
            tm[i][2] = Clerk.getRegisteredClerks().get(i).getLastName();
            tm[i][3] = Clerk.getRegisteredClerks().get(i).getEmail();
        }

        return tm;
    }
}
