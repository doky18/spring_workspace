package com.edu.springboard.model.gallery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.edu.springboard.domain.Gallery;
import com.edu.springboard.domain.Photo;
import com.edu.springboard.exception.GalleryException;


@Repository
public class JdbcGalleryDAO implements GalleryDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List selectAll() {
		//내부적으로 jdbc를 사용하지만 다 숨겨놓았다
		//즉, 개발자로 하여금 기존의 jdbc의 상투적 코드를 작성할 필요 없게 해놓은 것 뿐이지 기존 jdbc 맞음
		
		List galleryList=	jdbcTemplate.query("select * from gallery order by gallery_idx", new RowMapper<Gallery>() {
			public Gallery mapRow(ResultSet rs, int rowNum) throws SQLException {
				Gallery gallery = new Gallery();	//비어있는 gallery
				gallery.setGallery_idx(rs.getInt("gallery_idx"));
				gallery.setTitle(rs.getString("title"));
				gallery.setWriter(rs.getString("writer"));
				gallery.setContent(rs.getString("content"));
				gallery.setRegdate(rs.getString("regdate"));
				gallery.setHit(rs.getInt("hit"));
				
				//Gallery DTO가 보유한 photoList 채우기
				String sql="select * from photo where gallery_idx=?"; //길어서 sql로 빼줌
				
				List photoList=jdbcTemplate.query(sql, new Object[]{gallery.getGallery_idx()}, new RowMapper<Photo>() {
					public Photo mapRow(ResultSet rs, int rowNum) throws SQLException {
						Photo photo = new Photo();
						photo.setPhoto_idx(rs.getInt("photo_idx"));
						photo.setFilename(rs.getString("filename"));
						
						return photo;
					}
				});
				//구한 하위 포토 리스트를 다시 겔러리에 대입 
				gallery.setPhotoList(photoList);
				return gallery;
			}
		} );
		
		return galleryList;
	}

	@Override
	public Gallery select(int gallery_idx) {
		String sql = "select * from gallery where gallery_idx=?";
		
		Gallery gallery = jdbcTemplate.queryForObject(sql, new Object[] {gallery_idx}, new RowMapper<Gallery>(){
			public Gallery mapRow(ResultSet rs, int rowNum) throws SQLException {
				Gallery gallery = new Gallery();	//비어있는 gallery
				gallery.setGallery_idx(rs.getInt("gallery_idx"));
				gallery.setTitle(rs.getString("title"));
				gallery.setWriter(rs.getString("writer"));
				gallery.setContent(rs.getString("content"));
				gallery.setRegdate(rs.getString("regdate"));
				gallery.setHit(rs.getInt("hit"));
				
				//Gallery DTO가 보유한 photoList 채우기
				String sql="select * from photo where gallery_idx=?"; //길어서 sql로 빼줌
				
				List photoList=jdbcTemplate.query(sql, new Object[]{gallery.getGallery_idx()}, new RowMapper<Photo>() {
					public Photo mapRow(ResultSet rs, int rowNum) throws SQLException {
						Photo photo = new Photo();
						photo.setPhoto_idx(rs.getInt("photo_idx"));
						photo.setFilename(rs.getString("filename"));
						
						return photo;
					}
				});
				//구한 하위 포토 리스트를 다시 겔러리에 대입 
				gallery.setPhotoList(photoList);
				return gallery;
			}
		} );
		
		return gallery;
	}


	//CRUD는 모두 update() 메서드를 이용하면 된다
	@Override
	public void insert(Gallery gallery) throws GalleryException{
		StringBuilder sb = new StringBuilder();
		sb.append("insert into gallery(gallery_idx, title, writer, content)");
		sb.append(" values(seq_gallery.nextval, ?,?,?)");
		
		int result = jdbcTemplate.update(sb.toString(), new Object[] {gallery.getTitle(), gallery.getWriter(), gallery.getContent()});
		
		//mybatis처럼 insert 와 동시에 pk값 얻기
		String sql="select seq_gallery.currval as gallery_idx from dual";
		int gallery_idx=jdbcTemplate.queryForObject(sql, new RowMapper<Integer>() {
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt("gallery_idx");
			}
		});
		gallery.setGallery_idx(gallery_idx);
		if(result<1) {
			throw new GalleryException("등록 실패");
		}
	}

	@Override
	public void update(Gallery gallery) throws GalleryException{
		StringBuilder sb = new StringBuilder();
		sb.append("update gallery set title=?, writer=?, content=?");
		sb.append(" where gallery_idx=?");		
		int result = jdbcTemplate.update(sb.toString(), new Object[] {gallery.getTitle(), gallery.getWriter(), gallery.getContent(), gallery.getGallery_idx()});
		if(result<1) {
			throw new GalleryException("수정 실패");
		}
	}

	@Override
	public void delete(int gallery_idx) {
		StringBuilder sb = new StringBuilder();
		sb.append("delete from gallery");
		sb.append(" where gallery_idx=?");		
		int result = jdbcTemplate.update(sb.toString(), new Object[] {gallery_idx});
		if(result<1) {
			throw new GalleryException("삭제 실패");
		}
	}

}
