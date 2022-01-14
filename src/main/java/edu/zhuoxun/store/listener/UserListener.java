package edu.zhuoxun.store.listener; /**
 * Created by Jash
 */

import edu.zhuoxun.store.entry.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebListener
public class UserListener implements HttpSessionAttributeListener {

    public UserListener() {
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        Object o = sbe.getValue();
        if (o instanceof User) {
            ((User) o).setPassword(null);
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
        Object o = sbe.getSession().getAttribute(sbe.getName());
        if (o instanceof User) {
            ((User) o).setPassword(null);
        }
    }
}
