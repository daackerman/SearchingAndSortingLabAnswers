package RubricInterface;

import RubricInterface.*;
import java.lang.annotation.Annotation;
import java.util.*;

import java.lang.reflect.Method;

/**
 * Created by daackerman on 3/22/2017.
 */
public class RubricDumper {
    public static void DumpRubricItems(Class c, int startIdx) {
        HashMap<String, HashMap<String, RubricItem>> cat2Info = new HashMap<String, HashMap<String, RubricItem>>();
        Method[] ms = c.getMethods();
        for(Method m : ms) {
            Annotation[] as = m.getAnnotations();
            //System.out.println("Found " + as.length + " annotations\n");
            for (Annotation a : as) {
                if (a instanceof RubricItem) {
                    RubricItem ri = (RubricItem) a;
                    cat2Info.putIfAbsent(ri.category(), new HashMap<String, RubricItem>());
                    cat2Info.get(ri.category()).put(m.getName(), ri);
                }
            }
        }
        /*
            <category name="Functional">
        <item id="3" max="2" cases="AddNumbers">Numbers added correctly</item>
    </category>
         */
        int itemIdx = startIdx;
        for (String category : cat2Info.keySet())
        {
            System.out.println("<category name=\"" + category + "\">");
            for(String methodName : cat2Info.get(category).keySet())
            {
                RubricItem ri = cat2Info.get(category).get(methodName);
                System.out.print("<item id=\"");
                System.out.print(itemIdx);
                System.out.print("\" max=\"");
                System.out.print(ri.value());
                System.out.print("\" cases=\"");
                System.out.print(methodName);
                System.out.print("\">");
                System.out.print(ri.description());
                System.out.println("</item>");
                ++itemIdx;
            }
            System.out.println("</category>");
        }
    }
}
