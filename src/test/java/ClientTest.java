import org.junit.Rule;
import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Client.all().size(), 0);
  }

  @Test
  public void equals_returnsTrueIfClientsAretheSame() {
    Client firstClient = new Client("Asha", 30123, 1);
    Client secondClient = new Client("Asha", 30123, 1);
    assertTrue(firstClient.equals(secondClient));
  }

  @Test
  public void save_assignsIdToObject() {
    Client myClient = new Client("Asha", 30123, 1);
    myClient.save();
    Client savedClient = Client.all().get(0);
    assertEquals(myClient.getId(), savedClient.getId());
  }//
  // @Test
  // public void save_savesIntoDatabase_true() {
  //   Stylist newStylist = new Stylist("Bob");
  //   newStylist.save();
  //   assertTrue(Stylist.all().get(0).equals(newStylist));
  // }
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
