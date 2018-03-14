package controllers

import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import javax.inject.Inject
import org.krysalis.barcode4j.impl.upcean.EAN13Bean
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider
import play.api.mvc._


class BarCodesController @Inject()(cc: ControllerComponents) extends AbstractController(cc){

  val ImageResolution = 144

  def barcode(ean: Long) = Action {
    val MimeType = "image/png"
    try{
      val imageData = ean13BarCode(ean, MimeType)
      Ok(imageData).as(MimeType)
    }
    catch{
      case e: IllegalArgumentException =>
        BadRequest("Couldnt generate bar code. Error: " + e.getMessage)
    }
  }

  def ean13BarCode(ean: Long, mimeType: String): Array[Byte] = {
    val output: ByteArrayOutputStream = new ByteArrayOutputStream
    val canvas: BitmapCanvasProvider =
      new BitmapCanvasProvider(output, mimeType, ImageResolution, BufferedImage.TYPE_BYTE_BINARY, false, 0)

    val barcode = new EAN13Bean()
    barcode.generateBarcode(canvas,  String valueOf(ean))
    canvas.finish()

    output.toByteArray
  }
}
