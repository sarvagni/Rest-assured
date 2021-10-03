package testRun;

import org.testng.Assert;
import org.testng.annotations.Test;

import petStoreAPI.orders;
import petStoreAPI.user;
import petStoreAPI.pets;

public class testExecution {
	/**Add pet to the store, Update the same pet , fetch the details of the pet and the delet the pet 
	 * Upload the image of the pet
	 * thread.sleep is given because to interept the execution upto 10 seconds.
	 * @throws exception due to thread.sleep
	 * priority is given as 1 because this test should be run first.
	 */
	
	@Test(priority = 1)
	void pets() throws Exception
	{
		System.out.println("Adding a pet to the store.");
		int addingPetStatusCodeValidation=pets.addingPet();
		Assert.assertEquals(addingPetStatusCodeValidation, 200);
		Thread.sleep(10000);

		
		System.out.println("Updating the details of the pet.");
		Thread.sleep(10000);
		int updatingPetStatusCodeValidation=pets.updatingPet();
	    Assert.assertEquals(updatingPetStatusCodeValidation, 200);
	    
	    System.out.println("Fetching the details of the pet...");
		Thread.sleep(10000);
		int fetchPetStatusCodeValidation=pets.fetchPet();
		Assert.assertEquals(fetchPetStatusCodeValidation, 200);
		
		System.out.println("Uploading image of the pet..");
		Thread.sleep(10000);
		int uploadingImageStatusCodeValidation=pets.uploadPetImage();
		Assert.assertEquals(uploadingImageStatusCodeValidation, 200);
		
		System.out.println("Deleting the pet from the store...");
		Thread.sleep(10000);
		int deletePetStatusCodeValidation=pets.deletePet();
		Assert.assertEquals(deletePetStatusCodeValidation, 200);
	}
	
	/**Add User to the store, Update the same User , fetch the details of the user and the delet the user 
	 * thread.sleep is given because to interept the execution upto 10 seconds.
	 * @throws exception due to thread.sleep
	 * priority is given as 2 because this test should be run Second.
	 */
	@Test(priority = 2)
	void userCreation() throws Exception {

	
		System.out.println("Creating the User karthikeya124");
		int createUserStatusCodeValidation=user.userCreation();
		Assert.assertEquals(createUserStatusCodeValidation, 200);
		
		System.out.println("Updating the same User Karthikeya124");
		Thread.sleep(10000);
		
		
		int updateUserStatusCodeValidation=user.userUpdate();
		Assert.assertEquals(updateUserStatusCodeValidation, 200);
		
		System.out.println("Fetching the User Karthikeya124...");
		Thread.sleep(10000);
		
		int fetchUserStatusCodeValidation=user.fetchUser();
		Assert.assertEquals(fetchUserStatusCodeValidation, 200);
		
		System.out.println("Deleting the User Karthikeya124...");
		Thread.sleep(10000);
		
		int deleteUserStatusCodeValidation=user.deleteUser();
		Assert.assertEquals(deleteUserStatusCodeValidation, 200);
		
	}	
	/** Placing the order,fetching the details of the order and the deleting the order 
	 * thread.sleep is given because to interept the execution upto 10 seconds.
	 * @throws exception due to thread.sleep
	 * priority is given as 3 because this test should be run third.
	 */
	@Test(priority = 3)
	void ordersPlacing() throws Exception {
		
		System.out.println("Placing the order");
		int placingOrderStatusCodeValidation=orders.placingOrder();
		Assert.assertEquals(placingOrderStatusCodeValidation, 200);
		
		
		System.out.println("Fetching the order details..");
		Thread.sleep(10000);
		int fetchingOrderStatusCodeValidation=orders.fetchOrder();
		Assert.assertEquals(fetchingOrderStatusCodeValidation, 200);
		
		System.out.println("Deleting the order...");
		Thread.sleep(10000);
		int deletingOrderStatusCodeValidation=orders.deleteOrder();
		Assert.assertEquals(deletingOrderStatusCodeValidation, 200);
	
	} 
	

}
