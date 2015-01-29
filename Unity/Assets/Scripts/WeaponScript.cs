using UnityEngine;
using System.Collections;

public class WeaponScript : MonoBehaviour {
	public Transform bulletPrefab;
	public float shootingRate = 0.25f;
	private float shootCooldown;
	private bool isRight = true;

	// Use this for initialization
	void Start () {
		shootCooldown = 0f;
	}
	
	// Update is called once per frame
	void Update () {
		if (shootCooldown > 0)
			shootCooldown -= Time.deltaTime;
	}

	public void Attack(){
		//print ("In Attack method");
		if (CanAttack ()) {
			shootCooldown = shootingRate;
			//print ("I can attack");

			var bulletTransform = Instantiate (bulletPrefab) as Transform;
			//print("this is bullettransform" + bulletTransform);
			bulletTransform.position = transform.position;
			//print ("this is bullet gameobject" + bulletTransform.gameObject);
			ProjectileScript move = bulletTransform.gameObject.GetComponent<ProjectileScript> ();
			//print ("this if check " +  (move != null));
			//player
			if (move != null){
				//print ("I am in move");
				if (Input.GetKeyDown(KeyCode.RightArrow))
					isRight = true;
				if(Input.GetKeyDown(KeyCode.LeftArrow))
					isRight = false;
					
				print (isRight);

				if(isRight)
					move.direction = this.transform.right;
				else
					move.direction = this.transform.right * -1;
				print (move.direction);
			}
		}
	}

	public bool CanAttack() {
		return shootCooldown <= 0f;
	}
}
