package otus.rabeev.marketplace.service

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Service
import otus.rabeev.marketplace.dto.RequestDto
import otus.rabeev.marketplace.dto.ResponseDto
import java.sql.ResultSet

@Service
class RequestPropertyService(private val jdbcTemplate: JdbcTemplate) {

    companion object {
        private val rowMapper = RowMapper<ResponseDto> { resultSet: ResultSet, index: Int ->
            ResponseDto(
                id = resultSet.getString("id"),
                name = resultSet.getString("name"),
                description = resultSet.getString("description"),
                units = resultSet.getString("units"),
                unitMain = resultSet.getString("unitMain")
            )
        }
    }



    fun requestPropertyFromDB(requestDto: RequestDto): ResponseDto {


        val res = jdbcTemplate.query("select * from ${requestDto.dBName} where id = '${requestDto.id}'", rowMapper)[0]

        return res
    }

}
