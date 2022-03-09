package com.springboot.sprint1module2.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.sprint1.entity.PostEntity;
import com.springboot.sprint1.exception.PostNotFoundException;

import com.springboot.sprint1.model.Post;

import com.springboot.sprint1.repository.PostRepository;
import com.springboot.sprint1.service.PostService;
import com.springboot.sprint1.service.PostServiceImpl;
import com.springboot.sprint1.util.EntityModelUtil;

@SpringBootTest(classes = PostServiceTest.class)
public class PostServiceTest {

	@InjectMocks
	private PostService postService = new PostServiceImpl();

	@Mock
	private PostRepository postRepository;
	
	@Mock
	private EntityModelUtil entityModelUtil;

	@Test
	void testGetPostDetails() {

		PostEntity post = new PostEntity();
		post.setCategoryName("Medical");
		post.setDonorId(1);
		post.setFundCollected(50000);
		post.setFundNeeded(60000);
		post.setPostDate(LocalDate.now());
		post.setPostId(1);
		post.setUserDescription("Cancer");
		post.setUserId(1);
		
		Post post1 = new Post();
		post1.setCategoryName("Medical");
		post1.setDonorId(1);
		post1.setFundCollected(50000);
		post1.setFundNeeded(60000);
		post1.setPostDate(LocalDate.now());
		post1.setPostId(1);
		post1.setUserDescription("Cancer");
		post1.setUserId(1);

		Optional<PostEntity> optionalPost = Optional.of(post);
		int postId = 1;
		
		when(entityModelUtil.postModelToEntity(post1)).thenReturn(post);
		when(entityModelUtil.postEntityToModel(post)).thenReturn(post1);

		when(postRepository.findById(1)).thenReturn(optionalPost);

		Post existingPost = postService.getPostDetails(postId);

		assertEquals(post.getCategoryName(), existingPost.getCategoryName());
		assertEquals(post.getDonorId(), existingPost.getDonorId());
		assertEquals(post.getFundCollected(), existingPost.getFundCollected());
		assertEquals(post.getFundNeeded(), existingPost.getFundNeeded());
		assertEquals(post.getPostDate(), existingPost.getPostDate());
		assertEquals(post.getUserDescription(), existingPost.getUserDescription());
		assertEquals(post.getUserId(), existingPost.getUserId());

	}

	@Test
	 void testGetPostByIdNotFound() {

		int postId = 200;

		when(postRepository.findById(postId)).thenThrow(PostNotFoundException.class);

		assertThrows(PostNotFoundException.class, () -> postService.getPostById(postId));

	}

	@Test
    void testDeletePost() {

		int postId = 1;
		PostEntity post = new PostEntity();

		post.setCategoryName("Medical");
		post.setDonorId(1);
		post.setFundCollected(50000);
		post.setFundNeeded(60000);
		post.setPostDate(LocalDate.now());
		post.setPostId(1);
		post.setUserDescription("Cancer");
		post.setUserId(1);

		Optional<PostEntity> optional = Optional.of(post);
		when(postRepository.findById(1)).thenReturn(optional);
		postService.deletePost(post.getPostId());
		verify(postRepository, times(1)).deleteById(postId);
	}
	
	@Test
	void testCreatePost() {
		
		Post post = new Post();
		post.setCategoryName("Medical");
		post.setDonorId(1);
		post.setFundCollected(50000);
		post.setFundNeeded(60000);
		post.setPostDate(LocalDate.now());
		post.setPostId(1);
		post.setUserDescription("Cancer");
		post.setUserId(1);
		
		PostEntity postEntity = new PostEntity();
		postEntity.setCategoryName(post.getCategoryName());
		postEntity.setDonorId(post.getDonorId());
		postEntity.setFundCollected(post.getFundCollected());
		postEntity.setFundNeeded(post.getFundNeeded());
		postEntity.setPostDate(post.getPostDate());
		postEntity.setPostId(post.getPostId());
		postEntity.setUserDescription(post.getUserDescription());
		postEntity.setUserId(post.getUserId());
		
		when(entityModelUtil.postModelToEntity(post)).thenReturn(postEntity);
		when(entityModelUtil.postEntityToModel(postEntity)).thenReturn(post);
		when(postRepository.save(postEntity)).thenReturn(postEntity);
		
		assertEquals(postEntity.getCategoryName(),post.getCategoryName());
		assertEquals(postEntity.getDonorId(),post.getDonorId());
		assertEquals(postEntity.getFundCollected(),post.getFundCollected());
		assertEquals(postEntity.getFundNeeded(),post.getFundNeeded());
			
		
	}
	
	@Test
    void testUpdatePost() {

        PostEntity postEntity = new PostEntity();

        Post post = new Post();
		post.setCategoryName("Medical");
		post.setDonorId(1);
		post.setFundCollected(50000);
		post.setFundNeeded(60000);
		post.setPostDate(LocalDate.now());
		post.setPostId(1);
		post.setUserDescription("Cancer");
		post.setUserId(1);

          Optional<PostEntity> optionalPost = Optional.of(postEntity);

          when(postRepository.findById(1)).thenReturn(optionalPost);

          PostEntity updatedPostEntity = postRepository.save(postEntity);
 
          entityModelUtil.postEntityToModel(updatedPostEntity);
          postService.updatePost(post);

          verify(postRepository, times(1)).save(entityModelUtil.postModelToEntity(post));
    }
	
	

}
