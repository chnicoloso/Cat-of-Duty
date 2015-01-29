using UnityEngine;
using System.Collections;

public class ProjectileScript : MonoBehaviour {
	public int dmg = 1;
	public bool isEnemy1Shot = false;
	public bool isEnemy2Shot = false;
	public Vector2 movement = new Vector2(10, 10);
	public Vector2 direction = new Vector2 (1, 0);

	// Use this for initialization
	void Start () {
		Destroy (gameObject, 10);
	}
	
	// Update is called once per frame
	void Update () {
		movement = new Vector2 (movement.x * direction.x, movement.y * direction.y);
	}

	void FixedUpdate(){
		rigidbody2D.velocity = movement;
	}

	void onTriggerEnter2D(Collider2D otherCollider){
		ProjectileScript bullet = otherCollider.gameObject.GetComponent<ProjectileScript>();
		if (bullet != null) {
			Destroy(gameObject);
		}
		Destroy (bullet.gameObject);
	}
}
