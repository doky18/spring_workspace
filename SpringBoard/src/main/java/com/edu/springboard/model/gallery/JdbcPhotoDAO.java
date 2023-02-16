package com.edu.springboard.model.gallery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.edu.springboard.domain.Photo;
import com.edu.springboard.exception.GalleryException;
import com.edu.springboard.exception.PhotoException;

@Repository
public class JdbcPhotoDAO implements PhotoDAO{
	@Autowired
	private JdbcTemplate JdbcTemplate;

	@Override
	public List selectAll() {
		String sql ="select * from photo";
		List <Photo> photoList=JdbcTemplate.query(sql,  new RowMapper<Photo>(){
			public Photo mapRow(ResultSet rs, int rowNum) throws SQLException {
				Photo photo = new Photo();
				photo.setPhoto_idx(rs.getInt("photo_idx"));
				photo.setFilename(rs.getString("filename"));
				return photo;
			}
		});
		return photoList;
	}

	@Override
	public Photo select(int photo_idx) {
		String sql="select * from photo where photo_idx=?";
		Photo photo = JdbcTemplate.queryForObject(sql, new RowMapper<Photo>() {
			public Photo mapRow(ResultSet rs, int rowNum) throws SQLException {
				Photo photo= new Photo();
				photo.setPhoto_idx(rs.getInt("photo_idx"));
				photo.setFilename(rs.getString("filename"));
				return photo;
			}
		});
		return photo;
	}

	@Override
	public void insert(Photo photo) {
		StringBuilder sb= new StringBuilder();
		sb.append("insert into photo(photo_idx, gallery_idx, filename)");
		sb.append(" values(seq_photo.nextval, ?,?)");
		
		int result = JdbcTemplate.update(sb.toString(), new Object[] {
				photo.getGallery().getGallery_idx(), photo.getFilename()
		});
		if(result<1){
			throw new PhotoException("이미지 저장 실패");
		}	
	}

	@Override
	public void deleteByGallery(int gallery_idx) throws PhotoException{
		StringBuilder sb = new StringBuilder();
		sb.append("delete from photo where gallery_idx=?");
		
		int result = JdbcTemplate.update(sb.toString(), new Object[] {gallery_idx});
		if(result<1) {
			throw new GalleryException("삭제 실패");
		}
	}

}
