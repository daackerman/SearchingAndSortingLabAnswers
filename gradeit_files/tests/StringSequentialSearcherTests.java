import gradeit.*;
import org.junit.*;
import java.util.*;

//import RubricInterface.*;

/**
 * Created by daackerman on 3/21/2017.
 */
public class StringSequentialSearcherTests extends GradeItTest {
    public @interface RubricItem {
        String category();
        String description();
        int value();
    }

    //Begin Sequential Searcher Tests
    @RubricItem(category = "indexOf", description = "empty list returns -1", value = 1)
    @Test
    public void testIndexOfSSSEmpty() {
        List<String> list = Arrays.asList();
        Searcher s = new StringSequentialSearcher(list);
        Assert.assertEquals(-1, s.indexOf("a"));
    }

    @RubricItem(category = "indexOf", description = "singleton list returns 0 if there", value = 1)
    @Test
    public void testIndexOfSSSOneFound() {
        List<String> list = Arrays.asList("a");
        Searcher s = new StringSequentialSearcher(list);
        Assert.assertEquals(0, s.indexOf("a"));
    }

    @RubricItem(category = "indexOf", description = "singleton list returns -1 if not there", value = 1)
    @Test
    public void testIndexOfSSSOneNotFound() {
        List<String> list = Arrays.asList("a");
        Searcher s = new StringSequentialSearcher(list);
        Assert.assertEquals(-1, s.indexOf("b"));
    }

    @RubricItem(category = "indexOf", description = "list of two elements can return second index", value = 1)
    @Test
    public void testIndexOfSSSTwoFound() {
        List<String> list = Arrays.asList("a","b");
        Searcher s = new StringSequentialSearcher(list);
        Assert.assertEquals(1, s.indexOf("b"));
    }

    @RubricItem(category = "indexOf", description = "list of two elements returns -1 if not there", value = 1)
    @Test
    public void testIndexOfSSSTwoNotFound() {
        List<String> list = Arrays.asList("a","b");
        Searcher s = new StringSequentialSearcher(list);
        Assert.assertEquals(-1, s.indexOf("c"));
    }

    @RubricItem(category = "indexOf", description = "list of many elements returns 0 for first item", value = 1)
    @Test
    public void testIndexOfSSSManyFoundBeginning() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 26; i++) {
            list.add((char)('a' + i) + "");
        }
        Searcher s = new StringSequentialSearcher(list);
        Assert.assertEquals(0, s.indexOf("a"));
    }

    @RubricItem(category = "indexOf", description = "list of many elements returns middle for middle item", value = 1)
    @Test
    public void testIndexOfSSSManyFoundMiddle() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 26; i++) {
            list.add((char)('a' + i) + "");
        }
        Searcher s = new StringSequentialSearcher(list);
        Assert.assertEquals(12, s.indexOf("m"));
    }

    @RubricItem(category = "indexOf", description = "list of many elements returns last index for last item", value = 1)
    @Test
    public void testIndexOfSSSManyFoundEnd() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 26; i++) {
            list.add((char)('a' + i) + "");
        }
        Searcher s = new StringSequentialSearcher(list);
        Assert.assertEquals(25, s.indexOf("z"));
    }

    @RubricItem(category = "indexOf", description = "list of many elements returns each index for each item", value = 1)
    @Test
    public void testIndexOfSBSManyFoundAll() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 26; i++) {
            list.add((char)('a' + i) + "");
        }
        Searcher s = new StringSequentialSearcher(list);
        for (int i = 0; i < 26; i++) {
            Assert.assertEquals(i, s.indexOf((char)('a' + i)+""));
        }
    }

    @RubricItem(category = "indexOf", description = "list of many elements returns -1 if not there", value = 1)
    @Test
    public void testIndexOfSSSManyNotFound() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 26; i++) {
            list.add((char)('a' + i) + "");
        }
        Searcher s = new StringSequentialSearcher(list);
        Assert.assertEquals(-1, s.indexOf("A"));
    }

    //Begin Sequential Searcher Contains Tests
    @RubricItem(category = "contains", description = "empty list returns false", value = 1)
    @Test
    public void testContainsSSSBeginning() {
        List<String> list = Arrays.asList("a","b","c");
        Searcher s = new StringSequentialSearcher(list);
        Assert.assertTrue(s.contains("a"));
    }

    @RubricItem(category = "contains", description = "returns true for first item", value = 1)
    @Test
    public void testContainsSSSMiddle() {
        List<String> list = Arrays.asList("a","b","c");
        Searcher s = new StringSequentialSearcher(list);
        Assert.assertTrue(s.contains("b"));
    }

    @RubricItem(category = "contains", description = "returns true for middle item", value = 1)
    @Test
    public void testContainsSSSEnd() {
        List<String> list = Arrays.asList("a","b","c");
        Searcher s = new StringSequentialSearcher(list);
        Assert.assertTrue(s.contains("c"));
    }

    @RubricItem(category = "contains", description = "returns true for last item", value = 1)
    @Test
    public void testContainsSSSFalse() {
        List<String> list = Arrays.asList("a","b","c");
        Searcher s = new StringSequentialSearcher(list);
        Assert.assertFalse(s.contains("d"));
    }

    @RubricItem(category = "contains", description = "returns false for item not in list", value = 1)
    @Test
    public void testContainsSSSEmptyFalse() {
        List<String> list = Arrays.asList();
        Searcher s = new StringSequentialSearcher(list);
        Assert.assertFalse(s.contains("a"));
    }

    @RubricItem(category = "contains", description = "returns true for many items in a list", value = 1)
    @Test
    public void testContainsSSSManyTrue() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 13; i++) {
            list.add((char)('a' + 2 * i) + "");
        }
        Searcher s = new StringSequentialSearcher(list);
        for (int i = 0; i < 26; i += 2) {
            Assert.assertTrue(s.contains((char)('a' + i) + ""));
        }
    }

    @RubricItem(category = "contains", description = "returns false for many items not in a list", value = 1)
    @Test
    public void testContainsSSSManyFalse() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 13; i++) {
            list.add((char)('a' + 2 * i) + "");
        }
        Searcher s = new StringSequentialSearcher(list);
        for (int i = 1; i < 27; i += 2) {
            Assert.assertFalse(s.contains((char)('a' + i) + ""));
        }
    }
/*
    public static void main(String[] args) {
        RubricDumper.DumpRubricItems(StringSequentialSearcherTests.class, 220);
    }
*/
}
