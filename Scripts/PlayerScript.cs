using UnityEngine;

/// <summary>
/// Player controller and behavior
/// </summary>
public class PlayerScript : MonoBehaviour
{
	/// <summary>
	/// 1 - The speed of the ship
	/// </summary>
	public Vector2 speed = new Vector2(50, 50);
	public bool isDead;
	
	// 2 - Store the movement
	private Vector2 movement;

	void Start(){
		DestroyYourself ();
	}

	void DestroyYourself(){
		isDead = true;
	}

	public bool isItDead(){
		return isDead;
	}

	void Update()
	{
		float inputX = Input.GetAxis("Horizontal");
		float inputY = Input.GetAxis("Vertical");

		movement = new Vector2(
			speed.x * inputX,
			speed.y * inputY);

		bool shoot = Input.GetButtonDown("Fire3");
		//print ("shoot is " + shoot);
		// 3 - Retrieve axis information
		if (shoot)
		{
			//print ("Hi I hate you");
			WeaponScript weapon = GetComponent<WeaponScript>();
			if (weapon != null)
			{
				// false because the player is not an enemy
				weapon.Attack();
			}
		}
	}
	
	void FixedUpdate()
	{
		// 5 - Move the game object
		rigidbody2D.velocity = movement;

	}
}