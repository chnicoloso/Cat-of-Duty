using UnityEngine;
using System.Collections;

public class Player : MonoBehaviour 

{
	public float speed;
	private Rigidbody2D _myRigidbody;
	public float dir;
	private Animator anim;
	public bool facingright = true;
	private bool moving = true;
	public float move;
	private bool _canJump = true;

	// Use this for initialization
	void Start () 
	{
		_myRigidbody = this.rigidbody2D;
		//anim = GetComponent<Animator>();
	
	}

	void Flip()
	{	
		facingright = !facingright;
		Vector3 scale = transform.localScale;
		scale.x *= -1;
		transform.localScale = scale;
	}	

	void Move()
	{
		moving = !moving;
		move = Input.GetAxisRaw("Horizontal");
		_myRigidbody.velocity = new Vector2 (move * speed, _myRigidbody.velocity.y);
		//anim.SetFloat("Speed", Mathf.Abs(move));
	}

	void Jump()
	{

	}



	// Update is called once per frame
	void Update () 
	{

		if (moving) 
		{
			Move ();
		}

		if (!moving) 
		{
			Move();
		}
		 
		if (facingright == true && move < 0)
		{
			Flip();
		}

		else if (facingright == false && move > 0)
		{
			Flip();
		}

		if ((Input.GetAxisRaw("Vertical") == 1) && _canJump == true) 
		{
			anim.SetBool("Jump", true);
			_myRigidbody.velocity = new Vector2(_myRigidbody.velocity.x, 10);

		}
	
	
	}
}
