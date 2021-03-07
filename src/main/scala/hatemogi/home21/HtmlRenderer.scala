package hatemogi.home21

import org.fusesource.scalate.TemplateEngine
import scalatags.Text.all._

import java.io.File

object HtmlRenderer extends App {

  def scamlExample(): Unit = {
    val scamlTemplate = s"""
                           |%html
                           |  %body
                           |    여기서 적어봅시다.
                           |    다음줄입니다.
                           |""".stripMargin

    val path = new File(ClassLoader.getSystemResource("template").getPath) :: Nil
    val engine = TemplateEngine(path, "production")
    println(engine.layout("/test", engine.compileScaml(scamlTemplate)))
  }

  def scalaTagsExample(): Unit = {
    println(
      html(
        body(
          div("test"),
          p(
            raw("pre <em>emphasized</em> tag")
          )
        )
      )
    )
  }

  scalaTagsExample()
}
