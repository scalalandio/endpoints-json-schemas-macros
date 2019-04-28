package io.scalaland.endpoints.macros

import endpoints.algebra

import scala.language.experimental.macros
import scala.reflect.ClassTag

trait JsonSchemas extends algebra.JsonSchemas {

  def typeName(ct: ClassTag[_]): String =
    TypeNames.fullyQualified(ct)

  object TypeNames {

    def fullyQualified(ct: scala.reflect.ClassTag[_]): String = {
      val jvmName = ct.runtimeClass.getName
      val name = if(jvmName.nonEmpty && jvmName.last == '$') jvmName.init else jvmName
      name.replace('$','.')
    }

    def noPackageName(ct: scala.reflect.ClassTag[_]): String = {
      fullyQualified(ct).split('.').dropWhile(_.head.isLower).mkString
    }
  }

  def genericJsonSchema[A]: JsonSchema[A] =
    macro Macros.genericJsonSchemaImpl[A]
}
