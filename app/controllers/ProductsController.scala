package controllers

import javax.inject._
import play.api.mvc._
import models.Product
import play.api.i18n._

class ProductsController @Inject()(messagesAction: MessagesActionBuilder,
                                   cc: ControllerComponents) extends AbstractController(cc) {

  def list = messagesAction { implicit request: MessagesRequest[AnyContent] =>
    val products = Product.findAll
    Ok(views.html.products.list(products))
  }
}