//
//  ViewController.swift
//  ios
//
//  Created by 松本圭樹 on 2018/11/09.
//  Copyright © 2018年 keijumt. All rights reserved.
//

import UIKit
import common

class ViewController: UIViewController {

    @IBOutlet weak var sampleLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.sampleLabel.text = CommonKt.createApplicationScreenMessage()
    }


}

