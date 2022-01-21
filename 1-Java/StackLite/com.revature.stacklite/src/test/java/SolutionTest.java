package test.java;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.revature.stacklite.models.Solution;

class SolutionTest {

	@Test
	void setUpvoteShouldSet() {
		// Arrange
		int testUpVote = 4;
		Solution testSolution = new Solution();

		// Act
		try {
			testSolution.setUpvote(testUpVote);
			// Assert
			Assert.assertEquals(testUpVote, testSolution.getUpvote());
		} catch (Exception e) {
			Assert.fail();
		}

	}

	@Test
	void setUpvoteShouldThrowException() {
		// Arrange
		int testUpVote = -4;
		Solution testSolution = new Solution();
		
		//Act & Assert
		Assert.assertThrows(Exception.class, () -> testSolution.setUpvote(testUpVote));

	}

}
