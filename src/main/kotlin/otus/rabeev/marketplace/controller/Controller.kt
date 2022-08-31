package otus.rabeev.marketplace.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import otus.rabeev.marketplace.dto.RequestDto
import otus.rabeev.marketplace.dto.ResponseDto
import otus.rabeev.marketplace.service.RequestPropertyService
import javax.validation.Valid


@RestController
@Api(description = "Проба пера")
class Controller(private val requestPropertyService: RequestPropertyService) {

    @PostMapping("/product-property-request")
    @ApiOperation("Property request")
    fun propertyRequest(
        @Valid @RequestBody
        requestDto: RequestDto
    ): ResponseDto {

        return requestPropertyService.requestPropertyFromDB(requestDto)
    }
}