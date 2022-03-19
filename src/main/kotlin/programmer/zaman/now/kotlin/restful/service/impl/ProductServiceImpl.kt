package programmer.zaman.now.kotlin.restful.service.impl

import org.springframework.stereotype.Service
import programmer.zaman.now.kotlin.restful.entity.Product
import programmer.zaman.now.kotlin.restful.model.CreateProductRequest
import programmer.zaman.now.kotlin.restful.model.ProductResponse
import programmer.zaman.now.kotlin.restful.repository.ProductRepository
import programmer.zaman.now.kotlin.restful.service.ProductService
import programmer.zaman.now.kotlin.restful.validation.ValidationUtil
import java.util.*

@Service
class ProductServiceImpl(
    val productRepository: ProductRepository,
    val validationUtil: ValidationUtil
) : ProductService {
    override fun create(createProductRequest: CreateProductRequest): ProductResponse {
        validationUtil.validate(createProductRequest)

        val product = Product(id = createProductRequest.id!!, name = createProductRequest.name!!,
                price = createProductRequest.price!!, quantity = createProductRequest.quantity!!, createdAt = Date(),
                updatedAt = null)
        productRepository.save(product)

        return ProductResponse(id = product.id, name = product.name, price = product.price, quantity = product.quantity,
                createdAt = product.createdAt, updatedAt = product.updatedAt)
    }
}