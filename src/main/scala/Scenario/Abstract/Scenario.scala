package Scenario.Abstract

import Config.Properties

/**
  *   Abstract quy định cách sinh kịch bản, mọi kịch bản sinh ra đều phải kế thừa từ trait này.
  * Hiện tại, các kịch bản đang sử dụng 2 loại phân phối là phân phối đều và phân phói chuẩn
  * dánh cho việc random năng lượng của sensor và vị trí chủa chúng, công suất tiêu thụ năng
  * lượng của sensor được sinh theo phân phối chuẩn. Generator sẽ sử dụng các properties của
  * kịch bản để sinh dữ liệu. Danh sách các tham số quan trong trong properties của một kịch bản:
  *
  * 1. scenario.generator.size: Int (số lượng sensor trong kịch bản)
  *
  * 2. scenario.generator.energy.min: Double (Năng lượng cực tiểu của sensor)
  * 3. scenario.generator.energy.max: Double (Năng lượng cực đại của sensor)
  * 4. scenario.generator.energy.distribution: Properties (Quy định kiểu phân phối sử dụng để sinh năng lượng sensor, có thể có 3 properties con bên dưới)
  *   5. scenario.generator.energy.distribution.name: String (Tên kiểu phân phối của năng lượng)
  *   6. scenario.generator.energy.distribution.normal.mean: Double (mean khi sinh năng lượng theo phân phối chuẩn, bắt buộc phải có khi sử dụng phân phối chuẩn để sinh năng lượng)
  *   7. scenario.generator.energy.distribution.normal.standard_deviation: Double (độ lệch chuẩn khi sinh năng lượng theo phân phối chuẩn, bắt buộc phải có khi sử dụng phân phối chuẩn để sinh năng lượng)
  *   8. scenario.generator.energy.distribution.normal.type: String (Xác định mức độ cao thấp của năng lượng)
  *
  * 9. scenario.generator.location.min: Double (Cận dưới của vị trí trên một trục tọa độ)
  * 10. scenario.generator.location.max: Double: (Cận trên của vị trí trên một trục tọa độ)
  * 11. scenario.generator.location.distribution: Properties (Quy định kiểu phân phối sử dụng để sinh năng lượng sensor, có thể có 3 properties con bên dưới)
  *   12. scenario.generator.location.distribution.name: String (Tên kiểu phân phối của vị trí)
  *   13. scenario.generator.location.distribution.normal.mean: Double (mean khi sinh vị trí theo phân phối chuẩn, bắt buộc phải có khi sử dụng phân phối chuẩn để sinh vị trí)
  *   14. scenario.generator.location.distribution.normal.standard_deviation: Double (độ lệch chuẩn khi sinh vị trí theo phân phối chuẩn, bắt buộc phải có khi sử dụng phân phối chuẩn để sinh vị trí)
  *   15. scenario.generator.location.distribution.normal.type: String (Xác định mức độ gần xa của các sensor trong khu vực mục tiêu)
  *
  * 16. scenario.generator.consumption_rate.min: Double (Cận dưới của công suất tiêu thụ năng lượng của sensor)
  * 17. scenario.generator.consumption_rate.max: Double (Cận trên của công suất tiêu thụ năng lượng của sensor)
  * 18. scenario.generator.consumption_rate.mean: Double (mean khi sử dụng phân phối chuẩn để sinh xông suất tiêu thụ)
  * 19. scenario.generator.consumption_rate.standard_deviation: Double (độ lệch chuẩn khi sử dụng phân phối chuẩn để sinh xông suất tiêu thụ)
  *
  * <Lưu_ý_quan_trọng>: Các properties kiểu string phải được lấy theo các constant trong file FolderNames.scala
  *
  * @author sondn on 26/06/2019
  *
  ***/

abstract class Scenario {
  def getProperties(): Properties
  def createProperties(): Unit
}
