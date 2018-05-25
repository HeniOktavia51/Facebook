import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PagableList;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;

public class PostsFromPageExtractor {

/**
 * A simple Facebook4J client which
 * illustrates how to access group feeds / posts / comments.
 * 
 * @param args
 * @throws FacebookException 
 */
public static void main(String[] args) throws FacebookException {

    // Generate facebook instance.
    Facebook facebook = new FacebookFactory().getInstance();
    // Use default values for oauth app id.
	//ambil dari https://developers.facebook.com/apps/
    facebook.setOAuthAppId("1836031853364922", "41ded7280974f7fca560cac75d821d28");
    // Get an access token from: 
    // https://developers.facebook.com/tools/explorer
    // Copy and paste it below.
    String accessTokenString ="EAACEdEose0cBAGEBlpPJZB5Vbvw0VLygtbSdhw8op67CGH4lHJGH9DtR1kFBugfjlTVCbakZB2tQYcxKFeLX5tqX7L30ZC9dga9M6oWskBeGlaFSxE9XhZAJZCwOZCZAl8GCEhYPxjJsmWnyDWtQD1x8XYQROw1MvaV3UZAkEmRXRH0ZBCa1bOjuhQLUErjGmT1WSz104DC1rtAZDZD";
    AccessToken at = new AccessToken(accessTokenString);
    // Set access token.
    facebook.setOAuthAccessToken(at);

    // We're done.
    // Access group feeds.
    // You can get the group ID from:
    // https://developers.facebook.com/tools/explorer

      // Set limit to 25 feeds.
    ResponseList<Post> feeds = facebook.getFeed("187446750783",
            new Reading().limit(25));

        // For all 25 feeds...

            for (int i = 0; i < feeds.size(); i++) {
            // Get post.
            Post post = feeds.get(i);
            // Get (string) message.
            String message = post.getMessage();
                            // Print out the message.
            System.out.println(message);

            // Get more stuff...
            PagableList<Comment> comments = post.getComments();
            String date = post.getCreatedTime().toString();
            String name = post.getFrom().getName();
            String id = post.getId();

	facebook.postStatusMessage("Hello World im updating status again from Facebook4j");
        }           
    }
}
