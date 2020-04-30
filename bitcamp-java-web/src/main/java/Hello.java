import java.util.ArrayList;
import java.util.List;

public class Hello {

  public static void main(String[] args) {
    class JobPosting {
      int no;
      String title;
      List<String> files;
    }

    List<JobPosting> jobPostings = new ArrayList<>();

    for (JobPosting jobPost : jobPostings) {
      System.out.println(jobPost.no);
      System.out.println(jobPost.title);
      for (String file : jobPost.files) {
        System.out.println(file);
      }
    }

  }

}
