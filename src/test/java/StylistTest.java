import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Rule;

public class StylistTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Stylist.all().size(), 0);
  }
  @Test
  public void equals_returnsTrueIfStylistsAretheSame() {
    Stylist firstStylist = new Stylist("Madhu");
    Stylist secondStylist = new Stylist("Madhu");
    assertTrue(firstStylist.equals(secondStylist));
  }
  @Test
  public void save_assignsIdToObject() {
    Stylist myStylist = new Stylist("Madhu");
    myStylist.save();
    Stylist savedStylist = Stylist.all().get(0);
    assertEquals(myStylist.getId(), savedStylist.getId());
  }
  //
  // @Test
  // public void find_findsCategoryInDatabase_true() {
  //   Category myCategory = new Category("Banking");
  //   myCategory.save();
  //   Category savedCategory = Category.find(myCategory.getId());
  //   assertTrue(myCategory.equals(savedCategory));
  // }
  //
  // @Test
  // public void getTasks_retrievesAllTasksFromDatabase_tasksList() {
  //   Category myCategory = new Category("Banking");
  //   myCategory.save();
  //   Task firstTask = new Task("steal money", myCategory.getId());
  //   firstTask.save();
  //   Task secondTask = new Task("lots of money", myCategory.getId());
  //   secondTask.save();
  //   Task[] tasks = new Task[] { firstTask, secondTask };
  //   assertTrue(myCategory.getTasks().containsAll(Arrays.asList(tasks)));
  // }
}
