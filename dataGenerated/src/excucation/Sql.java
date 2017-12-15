package excucation;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import staticData.StaticData;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import config.JdbcConn;

public class Sql {

	/**
	 * 批量插入数据
	 * @param lines
	 * @return
	 */
	public static int insert(int lines){
		
		Connection conn = JdbcConn.getConn();
		int i = 0;
		String sql = "insert into tuser (`user_id`,`username`,`age`,`create_time`,`gender`) values (?,?,?,?,?)";
		PreparedStatement ps;
		
		String[] userNamesArr = StaticData.userNames.split(",");
		int[] ages = StaticData.ages;
		
		/* 循环插入数据 */
		try {
			for(int j=0;j<lines;j++){
				Random rand = new Random();
				int n = rand.nextInt(userNamesArr.length);
				int a = rand.nextInt(ages.length);
				String id = UUID.randomUUID().toString().replace("-", "");
				String userName = userNamesArr[n];
				Date dateUtil = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String timeStr = sdf.format(dateUtil.getTime());
				
				ps = (PreparedStatement)conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, userName);
				ps.setInt(3, ages[a]); 
				ps.setTimestamp(4, Timestamp.valueOf(timeStr));
				ps.setInt(5, j%2);
				
				i = ps.executeUpdate();
				ps.close();
				if (1 == i) {
					System.out.println("插入数量："+j);
					System.out.println("插入id为："+id);
					System.out.println("插入用户名为："+userName);
				}else {
					System.out.println("插入失败，id为："+id);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return i;
	}
}
