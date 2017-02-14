package eu.doppel_helix.dev.pamtest;

import com.sun.jna.Native;
import org.jvnet.libpam.PAM;
import org.jvnet.libpam.PAMException;
import org.jvnet.libpam.UnixUser;

public class Pam4JTest {

    public static void main(String[] args) throws PAMException {
        if (args.length > 0 && "true".equals(args[0])) {
            Native.setProtected(true);
        }
        System.out.println("Protection enabled: " + Native.isProtected());
        String userid = System.console().readLine("UserId: ");
        String password = new String(System.console().readPassword("Password: "));
        UnixUser u = new PAM("sshd").authenticate(userid, password);
        System.out.println("Shell:  " + u.getShell());
        System.out.println("Groups: " + u.getGroups());
    }

}
