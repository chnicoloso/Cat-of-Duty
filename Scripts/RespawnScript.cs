using UnityEngine;
using System.Collections;

public class RespawnScript : MonoBehaviour {
	/*//Add these in player scripts
	void Start(){
		DestroyYourself ();
	}
	
	void DestroyYourself(){
		isDead = true;
	}
	
	public bool isItDead(){
		return isDead;
	}*/

	public int deathCount;
	public PlayerScript playerPrefab;

	void Start(){
		deathCount = 0;
		checkPlayer();

	}

	void Update(){

	}


	void checkPlayer(){
		//print ("Hi");
		print (playerPrefab.GetComponent<PlayerScript> ().isItDead());
		if (!playerPrefab.GetComponent<PlayerScript>().isItDead()){
			//print("Yo");
			PlayerScript clone = Instantiate (playerPrefab, new Vector3 (0, 0, 0), Quaternion.identity) as PlayerScript;
			print (clone);
		}
	}
}