package ArrayUtilsTests;

import RubricInterface.RubricDumper;
import RubricInterface.RubricItem;
import gradeit.*;
import org.junit.Assert;
import org.junit.Test;
import tools.ArrayUtils;

import java.util.*;

/**
 * Created by daackerman on 3/17/2017.
 */
public class StringListTests extends GradeItTest {
    @RubricItem(category = "isSorted", description = "empty list", value = 1)
    @Test
    public void testSLIsSortedEmpty() {
        List<String> l = Arrays.asList();
        Assert.assertTrue(ArrayUtils.isSorted(l));
    }

    @RubricItem(category = "isSorted", description = "singleton list", value = 1)
    @Test
    public void testSLIsSortedOne() {
        List<String> l = Arrays.asList("foo");
        Assert.assertTrue(ArrayUtils.isSorted(l));
    }

    @RubricItem(category = "isSorted", description = "sorted list of two", value = 1)
    @Test
    public void testSLIsSortedTwoTrue() {
        List<String> l = Arrays.asList("bar", "foo");
        Assert.assertTrue(ArrayUtils.isSorted(l));
    }

    @RubricItem(category = "isSorted", description = "unsorted list of two", value = 1)
    @Test
    public void testSLIsSortedTwoFalse() {
        List<String> l = Arrays.asList("foo", "bar");
        Assert.assertFalse(ArrayUtils.isSorted(l));
    }

    @RubricItem(category = "isSorted", description = "sorted list of many", value = 1)
    @Test
    public void testSLIsSortedManyTrue() {
        String[] alpha = new String[26];
        for (int i = 0; i < 26; i++) {
            alpha[i] = (char)('a' + i) + "";
        }
        List<String> l = Arrays.asList(alpha);
        Assert.assertTrue(ArrayUtils.isSorted(l));
    }

    @RubricItem(category = "isSorted", description = "reverse sorted list of many", value = 1)
    @Test
    public void testSLIsSortedReverseFalse() {
        String[] alpha = new String[26];
        for (int i = 0; i < 26; i++) {
            alpha[i] = (char)('z' - i) + "";
        }
        List<String> l = Arrays.asList(alpha);
        Assert.assertFalse(ArrayUtils.isSorted(l));
    }

    @RubricItem(category = "isSorted", description = "almost sorted list of many", value = 1)
    @Test
    public void testSLIsSortedAlmostTrue() {
        String[] alpha = new String[26];
        for (int i = 0; i < 25; i++) {
            alpha[i] = (char)('a' + i) + "";
        }
        alpha[25] = "A";
        List<String> l = Arrays.asList(alpha);
        Assert.assertFalse(ArrayUtils.isSorted(l));
    }

    @RubricItem(category = "swap", description = "itself small list", value = 1)
    @Test
    public void testSLSwapItself() {
        List<String> l = Arrays.asList("foo");
        ArrayUtils.swap(l,0,0);
        Assert.assertEquals("[foo]", l.toString());
    }

    @RubricItem(category = "swap", description = "two elements small list", value = 1)
    @Test
    public void testSLSwapSimple() {
        List<String> l = Arrays.asList("foo", "bar");
        ArrayUtils.swap(l,0,1);
        Assert.assertEquals("[bar, foo]", l.toString());
    }

    @RubricItem(category = "swap", description = "two elements close larger list", value = 1)
    @Test
    public void testSLSwapFarther() {
        String[] alpha = new String[10];
        for (int i = 0; i < 10; i++) {
            alpha[i] = (char)('a' + i) + "";
        }
        List<String> l = Arrays.asList(alpha);
        ArrayUtils.swap(l,4,3);
        Assert.assertEquals("[a, b, c, e, d, f, g, h, i, j]", l.toString());
    }

    @RubricItem(category = "swap", description = "two elements far larger list", value = 1)
    @Test
    public void testSLSwapFirstAndLast() {
        String[] alpha = new String[10];
        for (int i = 0; i < 10; i++) {
            alpha[i] = (char)('a' + i) + "";
        }
        List<String> l = Arrays.asList(alpha);
        ArrayUtils.swap(l,0,9);
        Assert.assertEquals("[j, b, c, d, e, f, g, h, i, a]", l.toString());
    }

    @RubricItem(category = "swap", description = "throws exception for too large indexes", value = 1)
    @Test
    public void testSLSwapInvalidLarge() {
        boolean exceptionThrown = false;
        String[] alpha = new String[10];
        for (int i = 0; i < 10; i++) {
            alpha[i] = (char)('a' + i) + "";
        }
        List<String> l = Arrays.asList(alpha);
        try {
            ArrayUtils.swap(l, 0, 10);
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptionThrown = true;
        }
        Assert.assertTrue(exceptionThrown);
    }

    @RubricItem(category = "swap", description = "throws exception for too small indexes", value = 1)
    @Test
    public void testSLSwapInvalidNegative() {
        boolean exceptionThrown = false;
        String[] alpha = new String[10];
        for (int i = 0; i < 10; i++) {
            alpha[i] = (char)('a' + i) + "";
        }
        List<String> l = Arrays.asList(alpha);
        try {
            ArrayUtils.swap(l, -1, 3);
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptionThrown = true;
        }
        Assert.assertTrue(exceptionThrown);
    }

    @RubricItem(category = "swap", description = "throws exception on empty list", value = 1)
    @Test
    public void testSLSwapInvalidEmpty() {
        boolean exceptionThrown = false;
        List<String> l = Arrays.asList();
        try {
            ArrayUtils.swap(l, 0, 0);
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptionThrown = true;
        }
        Assert.assertTrue(exceptionThrown);
    }

    public static void main(String[] args) {
        RubricDumper.DumpRubricItems(StringListTests.class, 120);
    }
}
